/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.cli.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class ApiClientOptions {

    @Value("${server:}")
    private String serverUrl;
    @Value("${proxy:}")
    private String proxy;
    private boolean validationEnabled = false;
    @Value("${user.agent:Client CLI}")
    private String userAgent;
    private boolean debugEnabled = false;
    private boolean verifyingSsl = true;
    @Value("${access.token:}")
    private String accessToken;
    @Value("${refresh.token:}")
    private String refreshToken;
    @Value("${cert.path:}")
    private String certFilePath;
    @Value("${key.path:}")
    private String keyFilePath;
    @Value("${root.cert.path:}")
    private String rootCaFilePath;
    private boolean mtlsEnabled = false;
    @Value("${auth.server:}")
    private String authServer;
    @Value("${client.id:}")
    private String clientId;
    @Value("${jwks.path:keystore/keystore.jwks}")
    private String jwksPath;
    @Autowired
    Environment environment;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public boolean isValidationEnabled() {
        return validationEnabled;
    }

    public void setValidationEnabled(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    public boolean isVerifyingSsl() {
        return verifyingSsl;
    }

    public void setVerifyingSsl(boolean verifyingSsl) {
        this.verifyingSsl = verifyingSsl;
    }

    public void setAccessToken(String jwt) {
        this.accessToken = jwt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getCertFilePath() {
        return certFilePath;
    }

    public void setCertFilePath(String certFilePath) {
        this.certFilePath = certFilePath;
    }

    public String getKeyFilePath() {
        return keyFilePath;
    }

    public void setKeyFilePath(String keyFilePath) {
        this.keyFilePath = keyFilePath;
    }

    public String getRootCaFilePath() {
        return rootCaFilePath;
    }

    public void setRootCaFilePath(String rootCaFilePath) {
        this.rootCaFilePath = rootCaFilePath;
    }

    public boolean isMtlsEnabled() {
        return mtlsEnabled;
    }

    public void setMtlsEnabled(boolean mtlsEnabled) {
        this.mtlsEnabled = mtlsEnabled;
    }

    public void setAuthServer(String authServer) {
        this.authServer = authServer;
    }

    public String getAuthServer() {
        return authServer;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getJwksPath() {
        return jwksPath;
    }

    public void setJwksPath(String jwksPath) {
        this.jwksPath = jwksPath;
    }

    public String getWebPort() {
        return environment.getProperty("local.server.port");
    }
}
