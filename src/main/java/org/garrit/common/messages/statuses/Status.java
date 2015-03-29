package org.garrit.common.messages.statuses;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Response for a service status request.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Value
public class Status
{
    /**
     * A name which uniquely identifies this service instance within its
     * environment.
     */
    private String name;

    @Getter(AccessLevel.NONE)
    private long startTime;

    /**
     * Statuses of the capabilities provided by the service.
     */
    private HashMap<CapabilityType, CapabilityStatus> capabilityStatuses;

    /**
     * Construct the service status with a name.
     */
    public Status(String name)
    {
        this.name = name;
        this.startTime = System.currentTimeMillis();
        this.capabilityStatuses = new HashMap<>(CapabilityType.SIZE);
    }

    /**
     * Get the number of seconds for which the service has been running.
     * 
     * @return the number of seconds for which the service has been running
     */
    public long getUptime()
    {
        return (System.currentTimeMillis() - this.startTime) / 1000;
    }

    /**
     * Get the status of the specific features provided by the service.
     * 
     * @return the status of individual service features
     */
    @JsonProperty("provides")
    @JsonPropertyOrder({"executor", "judge", "reporter", "negotiator"})
    public Map<CapabilityType, CapabilityStatus> getCapabilityStatuses()
    {
        return Collections.unmodifiableMap(this.capabilityStatuses);
    }

    /**
     * Add a capability status. Calling this method will replace any other
     * status of the same {@link CapabilityType capability type}.
     * 
     * @param capability the capability to add
     */
    public void setCapabilityStatus(CapabilityStatus status)
    {
        this.capabilityStatuses.put(status.getCapabilityType(), status);
    }
}