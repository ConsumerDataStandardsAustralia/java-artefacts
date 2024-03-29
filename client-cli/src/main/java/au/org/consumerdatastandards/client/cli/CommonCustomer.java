/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.CommonCustomerAPI;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.ResponseCommonCustomer;
import au.org.consumerdatastandards.client.model.ResponseCommonCustomerDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
@ShellCommandGroup("CommonCustomer")
public class CommonCustomer extends ApiCliBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonCustomer.class);

    private final CommonCustomerAPI api = new CommonCustomerAPI();

    @ShellMethod("Get customer")
    public String getCustomer(@ShellOption(defaultValue = "false") boolean check) throws Exception {

        LOGGER.info("Get customer CLI initiated");

        api.setApiClient(clientFactory.create(true, check));
        ApiResponse<ResponseCommonCustomer> response = api.getCustomerWithHttpInfo();
        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.getCustomerCall(null);
            String requestUrl = call.request().url().toString();
            List<ConformanceError> conformanceErrors = validateMetadata(requestUrl, response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get customer detail")
    public String getCustomerDetail(@ShellOption(defaultValue = "false") boolean check) throws Exception {

        LOGGER.info("Get customer detail CLI initiated");

        api.setApiClient(clientFactory.create(true, check));
        ApiResponse<ResponseCommonCustomerDetail> response = api.getCustomerDetailWithHttpInfo();
        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.getCustomerDetailCall(null);
            String requestUrl = call.request().url().toString();
            List<ConformanceError> conformanceErrors = validateMetadata(requestUrl, response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }
}
