package au.org.consumerdatastandards.client.api.energy;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.model.energy.EnergyAccount;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountDetailResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountDetailV1;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountDetailV2;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountDetailV3;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountV1;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountV2;
import au.org.consumerdatastandards.client.model.energy.EnergyBalanceListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyBalanceResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyBillingListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyBillingTransactionBase;
import au.org.consumerdatastandards.client.model.energy.EnergyBillingTransactionV2;
import au.org.consumerdatastandards.client.model.energy.EnergyBillingTransactionV3;
import au.org.consumerdatastandards.client.model.energy.EnergyConcessionsResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyInvoiceListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyPaymentScheduleResponse;
import au.org.consumerdatastandards.client.model.energy.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.energy.ParamIntervalReadsEnum;
import au.org.consumerdatastandards.client.model.energy.RequestAccountIds;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnergyAccountsAPI extends ProtectedAPI {

    public <T extends EnergyAccount> ApiResult<EnergyAccountListResponse<T>> listEnergyAccounts(ParamAccountOpenStatus openStatus, Integer version, Integer page, Integer pageSize) throws ApiException {

        String path = "/energy/accounts";

        logger.trace("Building Call for listEnergyAccounts with path: {}, open-status: {}, version: {}, page: {}, page-size: {}",
                path,
                openStatus,
                version,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "open-status", openStatus);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);

        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", version.toString());
        addCdsProtectedApiHeaders(headerParams);

        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType;

        switch (version) {
            case 1:
                returnType = new TypeToken<EnergyAccountListResponse<EnergyAccountV1>>(){}.getType();
                break;
            case 2:
            default:
                returnType = new TypeToken<EnergyAccountListResponse<EnergyAccountV2>>(){}.getType();
                break;
        }

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public <T extends EnergyAccount> ApiResult<EnergyAccountDetailResponse<T>> getEnergyAccountDetail(String accountId, Integer version) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getEnergyAccountDetail()");
        }

        // create path and map variables
        String path = "/energy/accounts/" + apiClient.escapeString(accountId);

        logger.trace("Building Call for getEnergyAccountDetail with path: {}, version: {}, accountId: {}",
                path,
                version,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        headerParams.put("x-v", version.toString());

        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);

        Type returnType;

        switch (version) {
            case 1:
                returnType = new TypeToken<EnergyAccountDetailResponse<EnergyAccountDetailV1>>(){}.getType();
                break;
            case 2:
                returnType = new TypeToken<EnergyAccountDetailResponse<EnergyAccountDetailV2>>(){}.getType();
                break;
            case 3:
            default:
                returnType = new TypeToken<EnergyAccountDetailResponse<EnergyAccountDetailV3>>(){}.getType();
        }

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyPaymentScheduleResponse> getPaymentSchedule(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getPaymentSchedule()");
        }

        // create path and map variables
        String path = "/energy/accounts/" + apiClient.escapeString(accountId) + "/payment-schedule";

        logger.trace("Building Call for getPaymentSchedule with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyPaymentScheduleResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyConcessionsResponse> getConcessions(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getConcessions()");
        }

        // create path and map variables
        String path = "/energy/accounts/" + apiClient.escapeString(accountId) + "/concessions";

        logger.trace("Building Call for getConcessions with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyConcessionsResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyBalanceResponse> getBalanceForAccount(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getBalanceForAccount()");
        }

        // create path and map variables
        String path = "/energy/accounts/" + apiClient.escapeString(accountId) + "/balance";

        logger.trace("Building Call for getBalanceForAccount with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyBalanceResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyBalanceListResponse> listBalancesBulk(Integer page, Integer pageSize) throws ApiException {

        String path = "/energy/accounts/balances";

        logger.trace("Building Call for listBalancesBulk with path: {}, page: {}, page-size: {}",
                path,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyBalanceListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyBalanceListResponse> listBalancesForAccounts(RequestAccountIds accountIds, Integer page, Integer pageSize) throws ApiException {

        String path = "/energy/accounts/balances";

        logger.trace("Building Call for listBalancesForAccounts with path: {}, accountIds: {}, page: {}, page-size: {}",
                path,
                accountIds,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, accountIds, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyBalanceListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyInvoiceListResponse> getInvoicesForAccount(String accountId, OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getInvoicesForAccount()");
        }

        String path = "/energy/accounts/" + apiClient.escapeString(accountId) + "/invoices";

        logger.trace("Building Call for getInvoicesForAccount with path: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                oldestDate,
                newestDate,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyInvoiceListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyInvoiceListResponse> listInvoicesBulk(OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        String path = "/energy/accounts/invoices";

        logger.trace("Building Call for listInvoicesBulk with path: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                oldestDate,
                newestDate,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyInvoiceListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyInvoiceListResponse> listInvoicesForAccounts(RequestAccountIds accountIds,
            OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        String path = "/energy/accounts/invoices";

        logger.trace("Building Call for listInvoicesForAccounts with path: {}, accountIds: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                accountIds,
                oldestDate,
                newestDate,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, accountIds, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyInvoiceListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public <T extends EnergyBillingTransactionBase> ApiResult<EnergyBillingListResponse<T>> getBillingForAccount(String accountId,
            OffsetDateTime oldestTime, OffsetDateTime newestTime, Integer page, Integer pageSize, Integer version) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getBillingForAccount()");
        }

        String path = "/energy/accounts/" + apiClient.escapeString(accountId) + "/billing";

        logger.trace("Building Call for getBillingForAccount with path: {}, accountId: {}, oldest-time: {}, newest-time: {}, page: {}, page-size: {}, version: {}",
                path,
                accountId,
                oldestTime,
                newestTime,
                page,
                pageSize,
                version);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-time", oldestTime);
        addQueryParam(queryParams, "newest-date", newestTime);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", version.toString());
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType;

        switch (version) {
            case 1:
            case 2:
                returnType = new TypeToken<EnergyBillingListResponse<EnergyBillingTransactionV2>>(){}.getType();
                break;
            default:
                returnType = new TypeToken<EnergyBillingListResponse<EnergyBillingTransactionV3>>(){}.getType();
        }

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyBillingListResponse<EnergyBillingTransactionBase>> listBillingBulk(
            OffsetDateTime oldestTime, OffsetDateTime newestTime, Integer page, Integer pageSize, Integer version) throws ApiException {

        String path = "/energy/accounts/billing";

        logger.trace("Building Call for listBillingBulk with path: {}, oldest-time: {}, newest-time: {}, page: {}, page-size: {}, version: {}",
                path,
                oldestTime,
                newestTime,
                page,
                pageSize,
                version);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-time", oldestTime);
        addQueryParam(queryParams, "newest-date", newestTime);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", version.toString());
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType;

        switch (version) {
            case 1:
            case 2:
                returnType = new TypeToken<EnergyBillingListResponse<EnergyBillingTransactionV2>>(){}.getType();
                break;
            default:
                returnType = new TypeToken<EnergyBillingListResponse<EnergyBillingTransactionV3>>(){}.getType();
        }

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyBillingListResponse<EnergyBillingTransactionBase>> listBillingForAccounts(RequestAccountIds accountIds,
            OffsetDateTime oldestTime, OffsetDateTime newestTime, Integer page, Integer pageSize,
            ParamIntervalReadsEnum intervalReads, Integer version) throws ApiException {

        String path = "/energy/accounts/billing";

        logger.trace("Building Call for listBillingForAccounts with path: {}, accountIds: {}, oldest-time: {}, newest-time: {}, page: {}, page-size: {}, interval-reads: {}, version: {}",
                path,
                accountIds,
                oldestTime,
                newestTime,
                page,
                pageSize,
                intervalReads,
                version);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-time", oldestTime);
        addQueryParam(queryParams, "newest-date", newestTime);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        addQueryParam(queryParams, "interval-reads", intervalReads);
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", version.toString());
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, accountIds, headerParams, authNames, null);

        Type returnType;

        switch (version) {
            case 1:
            case 2:
                returnType = new TypeToken<EnergyBillingListResponse<EnergyBillingTransactionV2>>(){}.getType();
                break;
            default:
                returnType = new TypeToken<EnergyBillingListResponse<EnergyBillingTransactionV3>>(){}.getType();
        }

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }
}
