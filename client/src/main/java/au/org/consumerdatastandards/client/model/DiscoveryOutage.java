/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class DiscoveryOutage {

    private OffsetDateTime outageTime;

    private String duration;

    private Boolean isPartial;

    private String explanation;

    /**
     * Date and time that the outage is scheduled to begin
     * @return outageTime
     */
    public OffsetDateTime getOutageTime() {
        return outageTime;
    }

    public void setOutageTime(OffsetDateTime outageTime) {
        this.outageTime = outageTime;
    }

    /**
     * Planned duration of the outage. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     * @return duration
     */
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Flag that indicates, if present and set to true, that the outage is only partial meaning that only a subset of normally available end points will be affected by the outage
     * @return isPartial
     */
    public Boolean getIsPartial() {
        return isPartial;
    }

    public void setIsPartial(Boolean isPartial) {
        this.isPartial = isPartial;
    }

    /**
     * Provides an explanation of the current outage that can be displayed to an end customer
     * @return explanation
     */
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscoveryOutage discoveryOutage = (DiscoveryOutage) o;
        return Objects.equals(this.outageTime, discoveryOutage.outageTime) &&
            Objects.equals(this.duration, discoveryOutage.duration) &&
            Objects.equals(this.isPartial, discoveryOutage.isPartial) &&
            Objects.equals(this.explanation, discoveryOutage.explanation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            outageTime,
            duration,
            isPartial,
            explanation);
    }

    @Override
    public String toString() {
        return "class DiscoveryOutage {\n" +
            "   outageTime: " + toIndentedString(outageTime) + "\n" + 
            "   duration: " + toIndentedString(duration) + "\n" + 
            "   isPartial: " + toIndentedString(isPartial) + "\n" + 
            "   explanation: " + toIndentedString(explanation) + "\n" + 
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
