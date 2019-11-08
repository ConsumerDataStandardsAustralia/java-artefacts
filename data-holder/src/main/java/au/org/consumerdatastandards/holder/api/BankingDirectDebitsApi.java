package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.ResponseBankingDirectDebitAuthorisationList;
import au.org.consumerdatastandards.holder.model.ResponseErrorList;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Api(value = "BankingDirectDebits", description = "the BankingDirectDebits API")
public interface BankingDirectDebitsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Direct Debits For Account",
        nickname = "listDirectDebits",
        notes = "Obtain direct debit authorisations for a specific account",
        response = ResponseBankingDirectDebitAuthorisationList.class,
        tags = {"DirectDebits", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingDirectDebitAuthorisationList.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/{accountId}/direct-debits",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebits(
        @ApiParam(
            value = "ID of the account to get direct debit authorisations for.  Must have previously been returned by one of the account list end points.",
            required = true
        )
        @PathVariable("accountId") String accountId,
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") Integer pageSize,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-User-Agent", required = false) String xCdsUserAgent,
        @ApiParam(
            value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-subject", required = false) String xCdsSubject,
        @ApiParam(
            value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) String xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) String xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) String xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) String xV
    );

    @ApiOperation(
        value = "Get Direct Debits For Specific Accounts",
        nickname = "listDirectDebitsSpecificAccounts",
        notes = "Obtain direct debit authorisations for a specified list of accounts",
        response = ResponseBankingDirectDebitAuthorisationList.class,
        tags = {"DirectDebits", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Success",
            response = ResponseBankingDirectDebitAuthorisationList.class
        ),
        @ApiResponse(
            code = 422,
            message = "The request was well formed but was unable to be processed due to business logic specific to the request",
            response = ResponseErrorList.class
        )
    })
    @RequestMapping(
        value = "/banking/accounts/direct-debits",
        method = RequestMethod.POST
    )
    ResponseEntity<ResponseBankingDirectDebitAuthorisationList> listDirectDebitsSpecificAccounts(
        @ApiParam(value = "Array of specific accountIds to obtain authorisations for") @RequestBody RequestAccountIds accountIds,
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        ) @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        ) @RequestParam(value = "page-size", required = false, defaultValue = "25") Integer pageSize,
        @ApiParam(
            value = "The customers original User Agent header if the customer is currently logged in to the data recipient. Mandatory for customer present calls. Not required for unattended or unauthenticated calls. Base64 encoded contents which may included additional parameters."
        )
        @RequestHeader(value = "x-cds-User-Agent", required = false) String xCdsUserAgent,
        @ApiParam(
            value = "Subject identifier. Locally unique and never reassigned identifier within the Holder for the End-User. Mandatory for authenticated calls. Not required for unattended or unauthenticated calls."
        )
        @RequestHeader(value = "x-cds-subject", required = false) String xCdsSubject,
        @ApiParam(
            value = "The time when the customer last logged in to the data recipient. Required for all resource calls (customer present and unattended). Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-auth-date", required = false) String xFapiAuthDate,
        @ApiParam(
            value = "The customer's original IP address if the customer is currently logged in to the data recipient. The presence of this header indicates that the API is being called in a customer present context. Not to be included for unauthenticated calls."
        )
        @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
        @ApiParam(
            value = "An [RFC4122](https://tools.ietf.org/html/rfc4122) UID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction."
        )
        @RequestHeader(value = "x-fapi-interaction-id", required = false) String xFapiInteractionId,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) String xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder should respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) String xV
    );
}
