package au.org.consumerdatastandards.holder.api.banking;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.banking.BankingAccount;
import au.org.consumerdatastandards.holder.model.banking.BankingAccountDetail;
import au.org.consumerdatastandards.holder.model.banking.BankingBalance;
import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.banking.BankingTransaction;
import au.org.consumerdatastandards.holder.model.banking.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.banking.ErrorV2;
import au.org.consumerdatastandards.holder.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.banking.ParamProductCategory;
import au.org.consumerdatastandards.holder.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountListData;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountsBalanceById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountsBalanceList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingAccountsBalanceListData;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingTransactionById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingTransactionList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingTransactionListData;
import au.org.consumerdatastandards.holder.service.banking.BankingAccountService;
import au.org.consumerdatastandards.holder.service.banking.BankingTransactionService;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingAccountsApiController extends ApiControllerBase implements BankingAccountsApi {

    private final BankingAccountService accountService;
    private final BankingTransactionService transactionService;
    private final NativeWebRequest request;

    @Autowired
    public BankingAccountsApiController(NativeWebRequest request,
                                        BankingAccountService accountService,
                                        BankingTransactionService transactionService) {
        this.request = request;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingAccountById> getAccountDetail(String accountId,
                                                                       String xCdsClientHeaders,
                                                                       Date xFapiAuthDate,
                                                                       String xFapiCustomerIpAddress,
                                                                       UUID xFapiInteractionId,
                                                                       Integer xMinV,
                                                                       Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingAccountDetail bankingAccountDetail = accountService.getBankingAccountDetail(accountId);
        if (bankingAccountDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }

        ResponseBankingAccountById responseBankingAccountById = new ResponseBankingAccountById();
        responseBankingAccountById.setData(bankingAccountDetail);
        responseBankingAccountById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(responseBankingAccountById, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingTransactionById> getTransactionDetail(String accountId,
                                                                               String transactionId,
                                                                               String xCdsClientHeaders,
                                                                               Date xFapiAuthDate,
                                                                               String xFapiCustomerIpAddress,
                                                                               UUID xFapiInteractionId,
                                                                               Integer xMinV,
                                                                               Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingTransactionDetail transactionDetail = transactionService.getBankingTransactionDetail(transactionId);
        if (transactionDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        ResponseBankingTransactionById responseBankingTransactionById = new ResponseBankingTransactionById();
        responseBankingTransactionById.setData(transactionDetail);
        responseBankingTransactionById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(responseBankingTransactionById, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingTransactionList> getTransactions(String accountId,
                                                                          BigDecimal maxAmount,
                                                                          BigDecimal minAmount,
                                                                          OffsetDateTime newestTime,
                                                                          OffsetDateTime oldestTime,
                                                                          Integer page,
                                                                          Integer pageSize,
                                                                          String text,
                                                                          String xCdsClientHeaders,
                                                                          Date xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          UUID xFapiInteractionId,
                                                                          Integer xMinV,
                                                                          Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingTransaction> transactionPage = transactionService.findTransactions(
            accountId, maxAmount, minAmount, newestTime, oldestTime, text, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, transactionPage.getTotalPages(), xFapiInteractionId);
        ResponseBankingTransactionListData listData = new ResponseBankingTransactionListData();
        listData.setTransactions(transactionPage.getContent());
        ResponseBankingTransactionList responseBankingTransactionList = new ResponseBankingTransactionList();
        responseBankingTransactionList.setData(listData);
        responseBankingTransactionList.setLinks(getLinkData(request, transactionPage, actualPage, actualPageSize));
        responseBankingTransactionList.setMeta(getMetaData(transactionPage));
        return new ResponseEntity<>(responseBankingTransactionList, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingAccountList> listAccounts(Boolean isOwned,
                                                                   ParamAccountOpenStatus openStatus,
                                                                   Integer page,
                                                                   Integer pageSize,
                                                                   ParamProductCategory productCategory,
                                                                   String xCdsClientHeaders,
                                                                   Date xFapiAuthDate,
                                                                   String xFapiCustomerIpAddress,
                                                                   UUID xFapiInteractionId,
                                                                   Integer xMinV,
                                                                   Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        BankingAccount bankingAccount = new BankingAccount();
        if (openStatus != null && !openStatus.equals(ParamAccountOpenStatus.ALL)) {
            bankingAccount.setOpenStatus(BankingAccount.OpenStatus.valueOf(openStatus.name()));
        }
        if (productCategory != null ) {
            bankingAccount.setProductCategory(BankingProductCategory.valueOf(productCategory.name()));
        }
        Page<BankingAccount> accountPage = accountService.findBankingAccountsLike(isOwned, bankingAccount, PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, accountPage.getTotalPages(), xFapiInteractionId);
        ResponseBankingAccountListData listData = new ResponseBankingAccountListData();
        listData.setAccounts(accountPage.getContent());
        ResponseBankingAccountList responseBankingAccountList = new ResponseBankingAccountList();
        responseBankingAccountList.setData(listData);
        responseBankingAccountList.setLinks(getLinkData(request, accountPage, actualPage, actualPageSize));
        responseBankingAccountList.setMeta(getMetaData(accountPage));
        return new ResponseEntity<>(responseBankingAccountList, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingAccountsBalanceById> getBalance(String accountId,
                                                                         String xCdsClientHeaders,
                                                                         Date xFapiAuthDate,
                                                                         String xFapiCustomerIpAddress,
                                                                         UUID xFapiInteractionId,
                                                                         Integer xMinV,
                                                                         Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingBalance balance = accountService.getBankingBalance(accountId);
        if (balance == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        ResponseBankingAccountsBalanceById responseBankingAccountsBalanceById = new ResponseBankingAccountsBalanceById();
        responseBankingAccountsBalanceById.setData(balance);
        responseBankingAccountsBalanceById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(responseBankingAccountsBalanceById, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingAccountsBalanceList> listBalancesBulk(Boolean isOwned,
                                                                               ParamAccountOpenStatus paramOpenStatus,
                                                                               ParamProductCategory paramProductCategory,
                                                                               Integer page,
                                                                               Integer pageSize,
                                                                               String xCdsClientHeaders,
                                                                               Date xFapiAuthDate,
                                                                               String xFapiCustomerIpAddress,
                                                                               UUID xFapiInteractionId,
                                                                               Integer xMinV, Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        BankingAccount.OpenStatus openStatus = null;
        if (paramOpenStatus != null && !ParamAccountOpenStatus.ALL.equals(paramOpenStatus)) {
            openStatus = BankingAccount.OpenStatus.valueOf(paramOpenStatus.name());
        }
        BankingProductCategory productCategory = null;
        if (paramProductCategory != null) {
            productCategory = BankingProductCategory.valueOf(paramProductCategory.name());
        }
        Page<BankingBalance> balancePage = accountService.getBankingBalances(isOwned, productCategory, openStatus,
            PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, balancePage.getTotalPages(), xFapiInteractionId);
        return getBalanceListResponse(headers, actualPage, actualPageSize, balancePage);
    }

    @Override
    public ResponseEntity<ResponseBankingAccountsBalanceList> listBalancesSpecificAccounts(RequestAccountIds accountIds,
                                                                                           Integer page,
                                                                                           Integer pageSize,
                                                                                           String xCdsClientHeaders,Date xFapiAuthDate,
                                                                                           String xFapiCustomerIpAddress,
                                                                                           UUID xFapiInteractionId,
                                                                                           Integer xMinV,
                                                                                           Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        validatePageSize(pageSize, xFapiInteractionId);
        List<String> accountIdList = accountIds.getData().getAccountIds();
        validateAccountExistence(accountIdList, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingBalance> balancePage = accountService.getBankingBalances(accountIdList,
            PageRequest.of(actualPage - 1, actualPageSize));
        validatePageRange(actualPage, balancePage.getTotalPages(), xFapiInteractionId);
        return getBalanceListResponse(headers, actualPage, actualPageSize, balancePage);
    }

    private void validateAccountExistence(List<String> accountIds, UUID interactionId) {
        ArrayList<ErrorV2> errorList = new ArrayList<>();
        for (String accountId : accountIds) {
            if (!accountService.checkAccountExistence(accountId)) {
                errorList.add(createError("Unavailable Banking Account", "urn:au-cds:error:cds-banking:Authorisation/UnavailableBankingAccount", accountId));
            }
        }
        if (!errorList.isEmpty()) {
            throwCDSUnprocessableErrors(interactionId, errorList);
        }
    }

    private ResponseEntity<ResponseBankingAccountsBalanceList> getBalanceListResponse(HttpHeaders headers,
                                                                                      Integer actualPage,
                                                                                      Integer actualPageSize,
                                                                                      Page<BankingBalance> balancePage) {
        ResponseBankingAccountsBalanceListData listData = new ResponseBankingAccountsBalanceListData();
        listData.setBalances(balancePage.getContent());
        ResponseBankingAccountsBalanceList responseBankingAccountsBalanceList = new ResponseBankingAccountsBalanceList();
        responseBankingAccountsBalanceList.setData(listData);
        responseBankingAccountsBalanceList.setLinks(getLinkData(request, balancePage, actualPage, actualPageSize));
        responseBankingAccountsBalanceList.setMeta(getMetaData(balancePage));
        return new ResponseEntity<>(responseBankingAccountsBalanceList, headers, HttpStatus.OK);
    }
}