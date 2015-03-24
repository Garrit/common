package org.garrit.common.statuses;

import lombok.Data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the status of a reporter.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@JsonSerialize
public class ReporterStatus implements CapabilityStatus
{
    @Override
    public CapabilityType getCapabilityType()
    {
        return CapabilityType.REPORTER;
    }
}