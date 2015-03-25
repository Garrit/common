package org.garrit.common.messages.statuses;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the status of a reporter.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@JsonSerialize
public interface ReporterStatus extends CapabilityStatus
{
    @Override
    public default CapabilityType getCapabilityType()
    {
        return CapabilityType.REPORTER;
    }
}