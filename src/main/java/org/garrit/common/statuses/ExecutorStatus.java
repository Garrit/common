package org.garrit.common.statuses;

import lombok.Data;

/**
 * A representation of the status of an executor.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
public class ExecutorStatus implements CapabilityStatus
{
    /**
     * Languages supported by this executor.
     */
    public String[] languages;
    /**
     * Problems supported by this executor.
     */
    public String[] problems;
    /**
     * The IDs of submissions which have been delivered to this executor but
     * have not yet been evaluated.
     */
    public int[] queued;

    @Override
    public CapabilityType getCapabilityType()
    {
        return CapabilityType.EXECUTOR;
    }
}