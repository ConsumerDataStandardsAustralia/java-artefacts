/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class ResponseCommonDiscoveryStatusData {

    public enum Status {
        OK,
        PARTIAL_FAILURE,
        SCHEDULED_OUTAGE,
        UNAVAILABLE
    }

    private Status status;

    private String explanation;

    private OffsetDateTime detectionTime;

    private OffsetDateTime expectedResolutionTime;

    private OffsetDateTime updateTime;

    /**
     * Enumeration with values. OK (implementation is fully functional). PARTIAL_FAILURE (one or more end points are unexpectedly unavailable). UNAVAILABLE (the full implementation is unexpectedly unavailable). SCHEDULED_OUTAGE (an advertised outage is in effect)
     * @return status
     */
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Provides an explanation of the current outage that can be displayed to an end customer. Mandatory if the status property is any value other than OK
     * @return explanation
     */
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * The date and time that the current outage was detected. Should only be present if the status property is PARTIAL_FAILURE or UNAVAILABLE
     * @return detectionTime
     */
    public OffsetDateTime getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(OffsetDateTime detectionTime) {
        this.detectionTime = detectionTime;
    }

    /**
     * The date and time that full service is expected to resume (if known). Should not be present if the status property has a value of OK.
     * @return expectedResolutionTime
     */
    public OffsetDateTime getExpectedResolutionTime() {
        return expectedResolutionTime;
    }

    public void setExpectedResolutionTime(OffsetDateTime expectedResolutionTime) {
        this.expectedResolutionTime = expectedResolutionTime;
    }

    /**
     * The date and time that this status was last updated by the Data Holder.
     * @return updateTime
     */
    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseCommonDiscoveryStatusData responseCommonDiscoveryStatusData = (ResponseCommonDiscoveryStatusData) o;
        return Objects.equals(this.status, responseCommonDiscoveryStatusData.status) &&
            Objects.equals(this.explanation, responseCommonDiscoveryStatusData.explanation) &&
            Objects.equals(this.detectionTime, responseCommonDiscoveryStatusData.detectionTime) &&
            Objects.equals(this.expectedResolutionTime, responseCommonDiscoveryStatusData.expectedResolutionTime) &&
            Objects.equals(this.updateTime, responseCommonDiscoveryStatusData.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            status,
            explanation,
            detectionTime,
            expectedResolutionTime,
            updateTime);
    }

    @Override
    public String toString() {
        return "class ResponseCommonDiscoveryStatusData {\n" +
            "   status: " + toIndentedString(status) + "\n" + 
            "   explanation: " + toIndentedString(explanation) + "\n" + 
            "   detectionTime: " + toIndentedString(detectionTime) + "\n" + 
            "   expectedResolutionTime: " + toIndentedString(expectedResolutionTime) + "\n" + 
            "   updateTime: " + toIndentedString(updateTime) + "\n" + 
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
