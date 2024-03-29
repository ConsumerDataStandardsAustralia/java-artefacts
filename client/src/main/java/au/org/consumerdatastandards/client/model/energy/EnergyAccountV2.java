package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyAccountV2
 */
public class EnergyAccountV2 extends EnergyAccountV1 {

    private OpenStatus openStatus;

    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    @Override
    public boolean equals(Object o) {

        return super.equals(o) &&
                Objects.equals(this.openStatus, ((EnergyAccountV2)o).openStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getAccountNumber(), getDisplayName(), getCreationDate(), openStatus, getPlans());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountV2 {\n");
        sb.append("    accountId: ").append(toIndentedString(getAccountId())).append("\n");
        sb.append("    accountNumber: ").append(toIndentedString(getAccountNumber())).append("\n");
        sb.append("    displayName: ").append(toIndentedString(getDisplayName())).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(getCreationDate())).append("\n");
        sb.append("    openStatus: ").append(toIndentedString(openStatus)).append("\n");
        sb.append("    plans: ").append(toIndentedString(getPlans())).append("\n");
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
