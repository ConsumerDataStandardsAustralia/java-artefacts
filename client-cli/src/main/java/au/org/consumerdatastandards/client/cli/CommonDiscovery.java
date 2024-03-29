/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.CommonDiscoveryAPI;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.ResponseCommonDiscoveryStatus;
import au.org.consumerdatastandards.client.model.ResponseDiscoveryOutagesList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
@ShellCommandGroup("CommonDiscovery")
public class CommonDiscovery extends ApiCliBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDiscovery.class);

    private final CommonDiscoveryAPI api = new CommonDiscoveryAPI();

    @ShellMethod("Get outages")
    public String getOutages(@ShellOption(defaultValue = "false") boolean check) throws Exception {

        LOGGER.info("Get outages CLI initiated");

        api.setApiClient(clientFactory.create(false, check));
        ApiResponse<ResponseDiscoveryOutagesList> response = api.getOutagesWithHttpInfo();
        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.getOutagesCall(null);
            String requestUrl = call.request().url().toString();
            List<ConformanceError> conformanceErrors = validateMetadata(requestUrl, response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get status")
    public String getStatus(@ShellOption(defaultValue = "false") boolean check) throws Exception {

        LOGGER.info("Get status CLI initiated");

        api.setApiClient(clientFactory.create(false, check));
        ApiResponse<ResponseCommonDiscoveryStatus> response = api.getStatusWithHttpInfo();
        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.getStatusCall(null);
            String requestUrl = call.request().url().toString();
            List<ConformanceError> conformanceErrors = validateMetadata(requestUrl, response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }
}
