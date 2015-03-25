package org.garrit.common.statuses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A representation of the status of an executor.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@JsonPropertyOrder({"languages", "problems", "queued"})
public interface ExecutorStatus extends CapabilityStatus
{
    /**
     * @return languages supported by this executor
     */
    public Iterable<String> getLanguages();

    /**
     * @return problems supported by this executor
     */
    public Iterable<String> getProblems();

    /**
     * The IDs of submissions which have been delivered to this executor but
     * have not yet been evaluated.
     */
    public Iterable<Integer> getQueued();

    @Override
    public default CapabilityType getCapabilityType()
    {
        return CapabilityType.EXECUTOR;
    }
}