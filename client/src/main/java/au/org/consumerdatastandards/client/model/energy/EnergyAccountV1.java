package au.org.consumerdatastandards.client.model.energy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountV1
 */
public class EnergyAccountV1 implements EnergyAccount {
    private String accountId;
    private String accountNumber;
    private String displayName;

    private LocalDate creationDate;

    private List<EnergyAccountPlans> plans = new ArrayList<>();

    public EnergyAccountV1 accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * The ID of the account.  To be created in accordance with CDR ID permanence requirements
     *
     * @return accountId
     */
    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public EnergyAccountV1 accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId
     *
     * @return accountNumber
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EnergyAccountV1 displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyAccountV1 creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * The date that the account was created or opened
     *
     * @return creationDate
     */
    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public EnergyAccountV1 plans(List<EnergyAccountPlans> plans) {
        this.plans = plans;
        return this;
    }

    public EnergyAccountV1 addPlansItem(EnergyAccountPlans plansItem) {
        this.plans.add(plansItem);
        return this;
    }

    /**
     * The array of plans containing service points and associated plan details
     *
     * @return plans
     */
    public List<EnergyAccountPlans> getPlans() {
        return plans;
    }

    public void setPlans(List<EnergyAccountPlans> plans) {
        this.plans = plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountV1 energyAccount = (EnergyAccountV1) o;
        return Objects.equals(this.accountId, energyAccount.accountId) &&
                Objects.equals(this.accountNumber, energyAccount.accountNumber) &&
                Objects.equals(this.displayName, energyAccount.displayName) &&
                Objects.equals(this.creationDate, energyAccount.creationDate) &&
                Objects.equals(this.plans, energyAccount.plans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountNumber, displayName, creationDate, plans);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountV1 {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
        sb.append("}");
        return sb.toString();
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
