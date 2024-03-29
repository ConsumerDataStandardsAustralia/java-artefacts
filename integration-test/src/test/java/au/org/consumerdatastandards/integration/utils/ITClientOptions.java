/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.integration.utils;

import au.org.consumerdatastandards.client.ApiClientOptions;

import java.io.IOException;
import java.util.Properties;

public class ITClientOptions implements ApiClientOptions {

    private static final String SERVER = "server";
    private static final String PROXY = "proxy";
    private static final String VALIDATE = "validate";
    private static final String USER_AGENT = "user.agent";
    private static final String DEBUGGING = "debugging";
    private static final String VERIFYING_SSL = "verifying.ssl";
    private static final String ACCESS_TOKEN = "access.token";
    private static final String CERT_FILE_PATH = "cert.file.path";
    private static final String KEY_FILE_PATH = "key.file.path";
    private static final String ROOT_CA_FILE_PATH = "root.ca.file.path";
    private static final String MTLS_ENABLED = "mtls.enabled";
    private static final String AUTH_SERVER = "auth.server";
    private static final String CLIENT_ID = "client.id";
    private static final String REFRESH_TOKEN = "refresh.token";
    private static final String JWKS_PATH = "jwks.path";

    private Properties props = new Properties();

    public ITClientOptions() throws IOException {
        props.load(ITClientOptions.class.getResourceAsStream("/it.properties"));
    }
    @Override
    public String getServerUrl() {
        return props.getProperty(SERVER);
    }

    @Override
    public void setServerUrl(String serverUrl) {
        props.setProperty(SERVER, serverUrl);
    }

    @Override
    public String getProxy() {
        return props.getProperty(PROXY);
    }

    @Override
    public void setProxy(String proxy) {
        props.setProperty(PROXY, proxy);
    }

    @Override
    public boolean isValidationEnabled() {
        return Boolean.parseBoolean(props.getProperty(VALIDATE));
    }

    @Override
    public void setValidationEnabled(boolean validationEnabled) {
        props.setProperty(VALIDATE, Boolean.toString(validationEnabled));
    }

    @Override
    public String getUserAgent() {
        return props.getProperty(USER_AGENT);
    }

    @Override
    public void setUserAgent(String userAgent) {
        props.setProperty(USER_AGENT, userAgent);
    }

    @Override
    public boolean isDebugEnabled() {
        return Boolean.parseBoolean(props.getProperty(DEBUGGING));
    }

    @Override
    public void setDebugEnabled(boolean debugEnabled) {
        props.setProperty(DEBUGGING, Boolean.toString(debugEnabled));
    }

    @Override
    public boolean isVerifyingSsl() {
        return Boolean.parseBoolean(props.getProperty(VERIFYING_SSL));
    }

    @Override
    public void setVerifyingSsl(boolean verifyingSsl) {
        props.setProperty(DEBUGGING, Boolean.toString(verifyingSsl));
    }

    @Override
    public void setAccessToken(String jwt) {
        props.setProperty(ACCESS_TOKEN, jwt);
    }

    @Override
    public String getAccessToken() {
        return props.getProperty(ACCESS_TOKEN);
    }

    @Override
    public String getCertFilePath() {
        return props.getProperty(CERT_FILE_PATH);
    }

    @Override
    public void setCertFilePath(String certFilePath) {
        props.setProperty(CERT_FILE_PATH, certFilePath);
    }

    @Override
    public String getKeyFilePath() {
        return props.getProperty(KEY_FILE_PATH);
    }

    @Override
    public void setKeyFilePath(String keyFilePath) {
        props.setProperty(KEY_FILE_PATH, keyFilePath);
    }

    @Override
    public String getRootCaFilePath() {
        return props.getProperty(ROOT_CA_FILE_PATH);
    }

    @Override
    public void setRootCaFilePath(String rootCaFilePath) {
        props.setProperty(ROOT_CA_FILE_PATH, rootCaFilePath);
    }

    @Override
    public boolean isMtlsEnabled() {
        return Boolean.parseBoolean(props.getProperty(MTLS_ENABLED));
    }

    @Override
    public void setMtlsEnabled(boolean mtlsEnabled) {
        props.setProperty(MTLS_ENABLED, Boolean.toString(mtlsEnabled));
    }

    @Override
    public void setAuthServer(String authServer) {
        props.setProperty(AUTH_SERVER, authServer);
    }

    @Override
    public String getAuthServer() {
        return props.getProperty(AUTH_SERVER);
    }

    @Override
    public String getClientId() {
        return props.getProperty(CLIENT_ID);
    }

    @Override
    public void setClientId(String clientId) {
        props.setProperty(CLIENT_ID, clientId);
    }

    @Override
    public String getRefreshToken() {
        return props.getProperty(REFRESH_TOKEN);
    }

    @Override
    public void setRefreshToken(String refreshToken) {
        props.setProperty(REFRESH_TOKEN, refreshToken);
    }

    @Override
    public String getJwksPath() {
        return props.getProperty(JWKS_PATH);
    }

    @Override
    public void setJwksPath(String jwksPath) {
        props.setProperty(JWKS_PATH, jwksPath);
    }
}
