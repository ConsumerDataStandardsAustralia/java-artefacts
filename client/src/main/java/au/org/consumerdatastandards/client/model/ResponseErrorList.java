/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.util.List;
import java.util.Objects;

public class ResponseErrorList {

    private List<Error> errors;

    /**
     * Get errors
     * @return errors
     */
    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseErrorList responseErrorList = (ResponseErrorList) o;
        return Objects.equals(this.errors, responseErrorList.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            errors);
    }

    @Override
    public String toString() {
        return "class ResponseErrorList {\n" +
            "   errors: " + toIndentedString(errors) + "\n" + 
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
