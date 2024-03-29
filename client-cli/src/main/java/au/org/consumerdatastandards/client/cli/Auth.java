/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.ApiClientFactory;
import au.org.consumerdatastandards.client.ApiClientOptions;
import ch.qos.logback.classic.Logger;
import org.apache.commons.lang3.StringUtils;
import org.mitre.jose.keystore.JWKSetKeyStore;
import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.client.service.impl.StaticClientConfigurationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;

@ShellComponent
@ShellCommandGroup("Auth- and security-related Functions")
public class Auth {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Auth.class);

    @Autowired
    private ApiClientOptions apiClientOptions;

    @Autowired
    StaticClientConfigurationService clientConfig;

    @Autowired
    JWKSetKeyStore jwksKeyStore;

    @PostConstruct
    // Needs to be called after component initialised to init auth server and client id in case they come from application.properties
    public void init() {
        String authServer = apiClientOptions.getAuthServer();
        if (StringUtils.isNotBlank(authServer)) {
            Map<String, RegisteredClient> clients = clientConfig.getClients();
            Iterator<RegisteredClient> it = clients.values().iterator();
            RegisteredClient clientSettings = it.next();
            it.remove();
            clientSettings.setClientId(apiClientOptions.getClientId());
            clients.put(authServer, clientSettings);
        }
    }

    @ShellMethod("Set verifyingSsl, e.g. true, false")
    public void verifyingSsl(@ShellOption String verifyingSsl) {
        apiClientOptions.setVerifyingSsl(Boolean.getBoolean(verifyingSsl));
        LOGGER.info("VerifyingSsl is set to {}", verifyingSsl);
    }

    @ShellMethod("Setup client certificate and CA to enable MTLS connection to the server")
    public void setupMTLS(@ShellOption("root CA file path") String rootCaPath,
                          @ShellOption("client cert file path") String certFilePath,
                          @ShellOption("client key file path") String keyFilePath,
                          @ShellOption(value = "enable MTLS or not", defaultValue = "true") boolean mtlsEnabled) {
        apiClientOptions.setRootCaFilePath(rootCaPath);
        LOGGER.info("Root CA file path is set to {}", rootCaPath);
        apiClientOptions.setCertFilePath(certFilePath);
        LOGGER.info("Client certificate file path is set to {}", certFilePath);
        apiClientOptions.setKeyFilePath(keyFilePath);
        LOGGER.info("Client key file path is set to {}", keyFilePath);
        if (mtlsEnabled) {
            enableMTLS();
        } else {
            disableMTLS();
        }
    }

    @ShellMethod("Enable MTLS")
    public void enableMTLS() {
        apiClientOptions.setMtlsEnabled(true);
        LOGGER.info("MTLS enabled");
    }

    @ShellMethod("Disable MTLS")
    public void disableMTLS() {
        apiClientOptions.setMtlsEnabled(false);
        LOGGER.info("MTLS disabled");
    }

    @ShellMethod("Set access token to send as the Authorization: Bearer header (Property: access.token)")
    public void accessToken(@ShellOption String jwt) {
        apiClientOptions.setAccessToken(jwt);
    }

    @ShellMethod("Unset access token")
    public void unsetAccessToken() {
        ApiClientFactory.accessTokenExpiresAt = 0;
        apiClientOptions.setAccessToken(null);
    }

    @ShellMethod("Get currently set access token. The refresh token flow can update access token.")
    public String getAccessToken() {
        return apiClientOptions.getAccessToken();
    }

    @ShellMethod("Set the base URL of the OIDC Server (Property: auth.server)")
    public void authServer(@ShellOption String authServer) {
        apiClientOptions.setAuthServer(authServer);
        init();
    }

    @ShellMethod("Get configured OIDC Server base URL")
    public String getAuthServer() {
        return apiClientOptions.getAuthServer();
    }

    @ShellMethod("Set refresh token. The access token, if set and valid, takes precedence. (Property: refresh.token)")
    public void refreshToken(@ShellOption String refreshToken) {
        apiClientOptions.setRefreshToken(refreshToken);
    }

    @ShellMethod("Unset refresh token")
    public void unsetRefreshToken() {
        apiClientOptions.setRefreshToken(null);
    }

    @ShellMethod("Get refresh token")
    public String getRefreshToken() {
        return apiClientOptions.getRefreshToken();
    }

    @ShellMethod("Set client ID registered on the Auth Server (Property: client.id)")
    public void clientId(@ShellOption String clientId) {
        apiClientOptions.setClientId(clientId);
        init();
    }

    @ShellMethod("Get client ID")
    public String getClientId() {
        return apiClientOptions.getClientId();
    }

    @ShellMethod("Set JWKS keystore file path (Property: jwks.path)")
    public void jwksPath(@ShellOption String jwksPath) {
        apiClientOptions.setJwksPath(jwksPath);
        jwksKeyStore.setLocation(new FileSystemResource(jwksPath));
    }

    @ShellMethod("Get JWKS keystore file path")
    public String getJwksPath() {
        return apiClientOptions.getJwksPath();
    }
}
