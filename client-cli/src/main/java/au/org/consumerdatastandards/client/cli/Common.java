/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.ApiClientOptions;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("Common Functions")
public class Common {

    @Autowired
    private ApiClientOptions apiClientOptions;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Common.class);

    @ShellMethod("Set CDS server URL, e.g. http://data.holder/cds-au/v1 (Property: server)")
    public void server(@ShellOption String url) {
        apiClientOptions.setServerUrl(url);
        LOGGER.info("Server URL is set to {}", apiClientOptions.getServerUrl());
    }

    @ShellMethod("Set proxy, e.g. http://http-proxy:8080, https://https-proxy:8443, socks://socks-proxy:5050, none (Property: proxy)")
    public void proxy(@ShellOption String proxy) {
        apiClientOptions.setProxy(proxy);
        LOGGER.info("Proxy is set to {}", apiClientOptions.getProxy());
    }

    @ShellMethod("Setup minimum log level, default is INFO")
    public void setLogLevel(@ShellOption Level targetLevel) {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(targetLevel);
    }

    @ShellMethod("Retrieve current minimum log level")
    public void getLogLevel() {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        Level currentLevel = root.getLevel();
        root.setLevel(Level.INFO);
        // Need to make sure we are at least at info or the message won't print
        LOGGER.info("Log level currently set to: {}", currentLevel);
        root.setLevel(currentLevel);
    }

    @ShellMethod("Set browser user-agent. Sent in User-Agent and x-cds-client-headers HTTP headers. Default is Client CLI (Property: user.agent)")
    public void setUserAgent(@ShellOption String userAgent) {
        apiClientOptions.setUserAgent(userAgent);
    }

    @ShellMethod("Get browser user-agent")
    public void getUserAgent() {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);
        LOGGER.info("User Agent currently set to: {}", apiClientOptions.getUserAgent());
    }

    @ShellMethod("Enable client debug")
    public void enableClientDebug(@ShellOption(help = "true / false") String debugEnabled) {
        apiClientOptions.setDebugEnabled(Boolean.parseBoolean(debugEnabled));
    }

    @ShellMethod("Client debug enabled")
    public void getClientDebug() {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);
        LOGGER.info("Client debug is currently set to: {}", apiClientOptions.isDebugEnabled());
    }
}
