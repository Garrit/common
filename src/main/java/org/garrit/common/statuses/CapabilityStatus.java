package org.garrit.common.statuses;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Representation of the status of an individual feature/capability of the
 * service.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public interface CapabilityStatus
{
    /**
     * @return the type of capability represented by this status
     */
    @JsonIgnore
    public CapabilityType getCapabilityType();
}