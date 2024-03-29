package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingListResponseData
 */
public class EnergyBillingListResponseData<T extends EnergyBillingTransactionBase> {
    private List<T> transactions = new ArrayList<>();

    public EnergyBillingListResponseData transactions(List<T> transactions) {
        this.transactions = transactions;
        return this;
    }

    public EnergyBillingListResponseData addTransactionsItem(T transactionsItem) {
        this.transactions.add(transactionsItem);
        return this;
    }

    /**
     * Array of transactions sorted by date and time in descending order
     *
     * @return transactions
     */
    public List<T> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<T> transactions) {
        this.transactions = transactions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyBillingListResponseData<T> energyBillingListResponseData = (EnergyBillingListResponseData<T>) o;
        return Objects.equals(this.transactions, energyBillingListResponseData.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingListResponseData {\n");
        sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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
