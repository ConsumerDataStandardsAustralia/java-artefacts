/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.api;

import au.org.consumerdatastandards.client.ApiCallback;
import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.RequestAccountIds;
import au.org.consumerdatastandards.client.model.ResponseBankingScheduledPaymentsList;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingScheduledPaymentsAPI extends ProtectedAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingScheduledPaymentsAPI.class);

    /**
     * Build call for listScheduledPayments
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsCall(String accountId, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {

        Object postBody = null;

        // create path and map variables
        String path = "/banking/accounts/{accountId}/payments/scheduled"
            .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId));

        LOGGER.trace("Building Call for listScheduledPayments with path: {}, accountId: {}, page: {}, page-size: {}",
            path,
            accountId,
            page,
            pageSize);

        List<Pair> queryParams = new ArrayList<>();
        List<Pair> collectionQueryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        return apiClient.buildCall(path, "GET", queryParams, collectionQueryParams, postBody, headerParams, authNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listScheduledPaymentsValidateBeforeCall(String accountId, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling listScheduledPayments(Async)");
        }


        return listScheduledPaymentsCall(accountId, page, pageSize, _callback);
    }

    /**
     * Get Scheduled Payments for Account
     * Obtain scheduled, outgoing payments for a specific account
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ResponseBankingScheduledPaymentsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public ResponseBankingScheduledPaymentsList listScheduledPayments(String accountId, Integer page, Integer pageSize) throws ApiException {

        LOGGER.trace("listScheduledPayments with accountId: {}, page: {}, page-size: {}",
            accountId,
            page,
            pageSize);

        ApiResponse<ResponseBankingScheduledPaymentsList> resp = listScheduledPaymentsWithHttpInfo(accountId, page, pageSize);
        return resp.getBody();
    }

    /**
     * Get Scheduled Payments for Account
     * Obtain scheduled, outgoing payments for a specific account
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ApiResponse&lt;ResponseBankingScheduledPaymentsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public ApiResponse<ResponseBankingScheduledPaymentsList> listScheduledPaymentsWithHttpInfo(String accountId, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call call = listScheduledPaymentsValidateBeforeCall(accountId, page, pageSize, null);
        Type returnType = new TypeToken<ResponseBankingScheduledPaymentsList>(){}.getType();
        return apiClient.execute(call, returnType);
    }

    /**
     * Get Scheduled Payments for Account (asynchronously)
     * Obtain scheduled, outgoing payments for a specific account
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsAsync(String accountId, Integer page, Integer pageSize, final ApiCallback<ResponseBankingScheduledPaymentsList> _callback) throws ApiException {

        LOGGER.trace("Asynchronously listScheduledPayments with accountId: {}, page: {}, page-size: {}",
            accountId,
            page,
            pageSize);

        okhttp3.Call call = listScheduledPaymentsValidateBeforeCall(accountId, page, pageSize, _callback);
        Type returnType = new TypeToken<ResponseBankingScheduledPaymentsList>(){}.getType();
        apiClient.executeAsync(call, returnType, _callback);
        return call;
    }
    /**
     * Build call for listScheduledPaymentsBulk
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsBulkCall(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {

        Object postBody = null;

        // create path and map variables
        String path = "/banking/payments/scheduled";

        LOGGER.trace("Building Call for listScheduledPaymentsBulk with path: {}, product-category: {}, open-status: {}, is-owned: {}, page: {}, page-size: {}",
            path,
            productCategory,
            openStatus,
            isOwned,
            page,
            pageSize);

        List<Pair> queryParams = new ArrayList<>();
        List<Pair> collectionQueryParams = new ArrayList<>();
        addQueryParam(queryParams, "product-category", productCategory);
        addQueryParam(queryParams, "open-status", openStatus);
        addQueryParam(queryParams, "is-owned", isOwned);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        return apiClient.buildCall(path, "GET", queryParams, collectionQueryParams, postBody, headerParams, authNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listScheduledPaymentsBulkValidateBeforeCall(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {


        return listScheduledPaymentsBulkCall(productCategory, openStatus, isOwned, page, pageSize, _callback);
    }

    /**
     * Get Scheduled Payments Bulk
     * Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ResponseBankingScheduledPaymentsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public ResponseBankingScheduledPaymentsList listScheduledPaymentsBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {

        LOGGER.trace("listScheduledPaymentsBulk with product-category: {}, open-status: {}, is-owned: {}, page: {}, page-size: {}",
            productCategory,
            openStatus,
            isOwned,
            page,
            pageSize);

        ApiResponse<ResponseBankingScheduledPaymentsList> resp = listScheduledPaymentsBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        return resp.getBody();
    }

    /**
     * Get Scheduled Payments Bulk
     * Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ApiResponse&lt;ResponseBankingScheduledPaymentsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public ApiResponse<ResponseBankingScheduledPaymentsList> listScheduledPaymentsBulkWithHttpInfo(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call call = listScheduledPaymentsBulkValidateBeforeCall(productCategory, openStatus, isOwned, page, pageSize, null);
        Type returnType = new TypeToken<ResponseBankingScheduledPaymentsList>(){}.getType();
        return apiClient.execute(call, returnType);
    }

    /**
     * Get Scheduled Payments Bulk (asynchronously)
     * Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsBulkAsync(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize, final ApiCallback<ResponseBankingScheduledPaymentsList> _callback) throws ApiException {

        LOGGER.trace("Asynchronously listScheduledPaymentsBulk with product-category: {}, open-status: {}, is-owned: {}, page: {}, page-size: {}",
            productCategory,
            openStatus,
            isOwned,
            page,
            pageSize);

        okhttp3.Call call = listScheduledPaymentsBulkValidateBeforeCall(productCategory, openStatus, isOwned, page, pageSize, _callback);
        Type returnType = new TypeToken<ResponseBankingScheduledPaymentsList>(){}.getType();
        apiClient.executeAsync(call, returnType, _callback);
        return call;
    }
    /**
     * Build call for listScheduledPaymentsSpecificAccounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *   <tr>
     *       <td> Status Code </td>
     *       <td> Description </td>
     *       <td> Response Headers </td>
     *   </tr>
     *   <tr>
     *       <td> 200 </td>
     *       <td> Success </td>
     *       <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     *   <tr>
     *       <td> 422 </td>
     *       <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *       <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsSpecificAccountsCall(RequestAccountIds accountIds, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {

        // create path and map variables
        String path = "/banking/payments/scheduled";

        LOGGER.trace("Building Call for listScheduledPaymentsSpecificAccounts with path: {}, accountIds: {}, page: {}, page-size: {}",
            path,
            accountIds,
            page,
            pageSize);

        List<Pair> queryParams = new ArrayList<>();
        List<Pair> collectionQueryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        return apiClient.buildCall(path, "POST", queryParams, collectionQueryParams, accountIds, headerParams, authNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listScheduledPaymentsSpecificAccountsValidateBeforeCall(RequestAccountIds accountIds, Integer page, Integer pageSize, final ApiCallback _callback) throws ApiException {

        // verify the required parameter 'accountIds' is set
        if (accountIds == null) {
            throw new ApiException("Missing the required parameter 'accountIds' when calling listScheduledPaymentsSpecificAccounts(Async)");
        }


        return listScheduledPaymentsSpecificAccountsCall(accountIds, page, pageSize, _callback);
    }

    /**
     * Get Scheduled Payments For Specific Accounts
     * Obtain scheduled payments for a specified list of accounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ResponseBankingScheduledPaymentsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *   <tr>
     *       <td> Status Code </td>
     *       <td> Description </td>
     *       <td> Response Headers </td>
     *   </tr>
     *   <tr>
     *       <td> 200 </td>
     *       <td> Success </td>
     *       <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     *   <tr>
     *       <td> 422 </td>
     *       <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *       <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     * </table>
     */
    public ResponseBankingScheduledPaymentsList listScheduledPaymentsSpecificAccounts(RequestAccountIds accountIds, Integer page, Integer pageSize) throws ApiException {

        LOGGER.trace("listScheduledPaymentsSpecificAccounts with accountIds: {}, page: {}, page-size: {}",
            accountIds,
            page,
            pageSize);

        ApiResponse<ResponseBankingScheduledPaymentsList> resp = listScheduledPaymentsSpecificAccountsWithHttpInfo(accountIds, page, pageSize);
        return resp.getBody();
    }

    /**
     * Get Scheduled Payments For Specific Accounts
     * Obtain scheduled payments for a specified list of accounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ApiResponse&lt;ResponseBankingScheduledPaymentsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *   <tr>
     *       <td> Status Code </td>
     *       <td> Description </td>
     *       <td> Response Headers </td>
     *   </tr>
     *   <tr>
     *       <td> 200 </td>
     *       <td> Success </td>
     *       <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     *   <tr>
     *       <td> 422 </td>
     *       <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *       <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     * </table>
     */
    public ApiResponse<ResponseBankingScheduledPaymentsList> listScheduledPaymentsSpecificAccountsWithHttpInfo(RequestAccountIds accountIds, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call call = listScheduledPaymentsSpecificAccountsValidateBeforeCall(accountIds, page, pageSize, null);
        Type returnType = new TypeToken<ResponseBankingScheduledPaymentsList>(){}.getType();
        return apiClient.execute(call, returnType);
    }

    /**
     * Get Scheduled Payments For Specific Accounts (asynchronously)
     * Obtain scheduled payments for a specified list of accounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     *    <tr>
     *        <td> 422 </td>
     *        <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *        <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsSpecificAccountsAsync(RequestAccountIds accountIds, Integer page, Integer pageSize, final ApiCallback<ResponseBankingScheduledPaymentsList> _callback) throws ApiException {

        LOGGER.trace("Asynchronously listScheduledPaymentsSpecificAccounts with accountIds: {}, page: {}, page-size: {}",
            accountIds,
            page,
            pageSize);

        okhttp3.Call call = listScheduledPaymentsSpecificAccountsValidateBeforeCall(accountIds, page, pageSize, _callback);
        Type returnType = new TypeToken<ResponseBankingScheduledPaymentsList>(){}.getType();
        apiClient.executeAsync(call, returnType, _callback);
        return call;
    }

    private void addQueryParam(List<Pair> queryParams, String paramName, Object paramValue) {
        if (paramValue != null) {
            LOGGER.trace("Adding query parameter of {} with value of {}", paramName, paramValue);
            queryParams.addAll(apiClient.parameterToPair(paramName, paramValue));
        }
    }
}
