/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.api.BankingProductsAPI;
import au.org.consumerdatastandards.client.api.BankingProductsAPI.ParamEffective;
import au.org.consumerdatastandards.client.cli.support.ApiUtil;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.ParamProductCategory;
import au.org.consumerdatastandards.client.model.ResponseBankingProductById;
import au.org.consumerdatastandards.client.model.ResponseBankingProductList;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.PayloadValidator;
import au.org.consumerdatastandards.support.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("BankingProducts")
public class BankingProducts extends ApiCliBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingProducts.class);

    private PayloadValidator payloadValidator = new PayloadValidator();
    private final BankingProductsAPI api = new BankingProductsAPI();

    @ShellMethod("Get product detail")
    public String getProductDetail(@ShellOption(defaultValue = ShellOption.NULL) Boolean check,
        @ShellOption(defaultValue = ShellOption.NULL) String productId,
        @ShellOption(defaultValue = "1") Integer version) throws Exception {

        LOGGER.info("Get product detail CLI initiated with productId: {}, version: {}",
            productId, version);

        api.setApiClient(ApiUtil.createApiClient(apiClientOptions));
        ResponseBankingProductById response = api.getProductDetail(productId, version);
        if (apiClientOptions.isValidationEnabled() || (check != null && check)) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.getProductDetailCall(productId, version, null);
            List<ConformanceError> conformanceErrors = payloadValidator
                .validateResponse(call.request().url().toString(), response, "getProductDetail", ResponseCode.OK);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }

    @ShellMethod("List products")
    public String listProducts(@ShellOption(defaultValue = ShellOption.NULL) Boolean check,
        @ShellOption(defaultValue = ShellOption.NULL) String brand,
        @ShellOption(defaultValue = ShellOption.NULL) ParamEffective effective,
        @ShellOption(defaultValue = ShellOption.NULL) Integer page,
        @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
        @ShellOption(defaultValue = ShellOption.NULL) ParamProductCategory productCategory,
        @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime updatedSince,
        @ShellOption(defaultValue = "1") Integer version) throws Exception {

        LOGGER.info("List products CLI initiated with brand: {}, effective: {}, page: {}, page-size: {}, product-category: {}, updated-since: {}, version: {}",
            brand,
            effective,
            page,
            pageSize,
            productCategory,
            updatedSince,
            version);

        api.setApiClient(ApiUtil.createApiClient(apiClientOptions));
        ResponseBankingProductList response = api.listProducts(effective, updatedSince, brand, productCategory, version, page, pageSize);
        if (apiClientOptions.isValidationEnabled() || (check != null && check)) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.listProductsCall(effective, updatedSince, brand, productCategory, version, page, pageSize, null);
            List<ConformanceError> conformanceErrors = payloadValidator
                .validateResponse(call.request().url().toString(), response, "listProducts", ResponseCode.OK);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }
}
