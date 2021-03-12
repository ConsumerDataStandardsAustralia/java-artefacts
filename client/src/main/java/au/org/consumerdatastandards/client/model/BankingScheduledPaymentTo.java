/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

/**
 * Object containing details of the destination of the payment. Used to specify a variety of payment destination types
 */
public class BankingScheduledPaymentTo {

    public enum ToUType {
        accountId,
        payeeId,
        domestic,
        biller,
        international
    }

    private ToUType toUType;

    private String accountId;

    private String payeeId;

    private BankingDomesticPayee domestic;

    private BankingBillerPayee biller;

    private BankingInternationalPayee international;

    private String nickname;

    private String payeeReference;

    /**
     * The type of object provided that specifies the destination of the funds for the payment.
     * @return toUType
     */
    public ToUType getToUType() {
        return toUType;
    }

    public void setToUType(ToUType toUType) {
        this.toUType = toUType;
    }

    /**
     * Present if toUType is set to accountId. Indicates that the payment is to another account that is accessible under the current consent
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Present if toUType is set to payeeId. Indicates that the payment is to registered payee that can be accessed using the payee end point. If the Bank Payees scope has not been consented to then a payeeId should not be provided and the full payee details should be provided instead
     * @return payeeId
     */
    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    /**
     * Get domestic
     * @return domestic
     */
    public BankingDomesticPayee getDomestic() {
        return domestic;
    }

    public void setDomestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
    }

    /**
     * Get biller
     * @return biller
     */
    public BankingBillerPayee getBiller() {
        return biller;
    }

    public void setBiller(BankingBillerPayee biller) {
        this.biller = biller;
    }

    /**
     * Get international
     * @return international
     */
    public BankingInternationalPayee getInternational() {
        return international;
    }

    public void setInternational(BankingInternationalPayee international) {
        this.international = international;
    }

    /**
     * The short display name of the payee as provided by the customer unless toUType is set to payeeId. Where a customer has not provided a nickname, a display name derived by the bank for payee should be provided that is consistent with existing digital banking channels
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * The reference for the transaction, if applicable, that will be provided by the originating institution for the specific payment. If not empty, it overrides the value provided at the BankingScheduledPayment level.
     * @return payeeReference
     */
    public String getPayeeReference() {
        return payeeReference;
    }

    public void setPayeeReference(String payeeReference) {
        this.payeeReference = payeeReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentTo bankingScheduledPaymentTo = (BankingScheduledPaymentTo) o;
        return Objects.equals(this.toUType, bankingScheduledPaymentTo.toUType) &&
            Objects.equals(this.accountId, bankingScheduledPaymentTo.accountId) &&
            Objects.equals(this.payeeId, bankingScheduledPaymentTo.payeeId) &&
            Objects.equals(this.nickname, bankingScheduledPaymentTo.nickname) &&
            Objects.equals(this.payeeReference, bankingScheduledPaymentTo.payeeReference) &&
            Objects.equals(this.domestic, bankingScheduledPaymentTo.domestic) &&
            Objects.equals(this.biller, bankingScheduledPaymentTo.biller) &&
            Objects.equals(this.international, bankingScheduledPaymentTo.international);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            toUType,
            accountId,
            payeeId,
            nickname,
            payeeReference,
            domestic,
            biller,
            international);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentTo {\n" +
            "   toUType: " + toIndentedString(toUType) + "\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" +
            "   payeeId: " + toIndentedString(payeeId) + "\n" +
            "   nickname: " + toIndentedString(nickname) + "\n" +
            "   payeeReference: " + toIndentedString(payeeReference) + "\n" +
            "   domestic: " + toIndentedString(domestic) + "\n" +
            "   biller: " + toIndentedString(biller) + "\n" +
            "   international: " + toIndentedString(international) + "\n" +
            "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
