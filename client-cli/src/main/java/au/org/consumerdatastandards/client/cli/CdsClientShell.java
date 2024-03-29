/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.cli.support.ClientCLIOptions;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

import java.security.Security;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CdsClientShell extends SpringBootServletInitializer {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        SpringApplication.run(CdsClientShell.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("cds-client:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
    
    @Bean
    public ClientCLIOptions apiClientOptions() {
        return new ClientCLIOptions();
    }
}
