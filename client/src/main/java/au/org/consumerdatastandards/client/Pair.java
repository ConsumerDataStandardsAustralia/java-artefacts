/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client;

public class Pair {
    private String name = "";
    private String value = "";

    public Pair (String name, String value) {
        setName(name);
        setValue(value);
    }

    private void setName(String name) {
        if (!isValidString(name)) {
            return;
        }

        this.name = name;
    }

    private void setValue(String value) {
        if (isValidString(value)) {
            this.value = value;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    private boolean isValidString(String arg) {
        if (arg == null) {
            return false;
        }

        return !arg.trim().isEmpty();
    }
}
