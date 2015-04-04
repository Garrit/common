package org.garrit.common.messages;

import lombok.Data;

import org.garrit.common.messages.statuses.CapabilityType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A message indicating an error occurring at some stage of processing.
 *
 * @param <T> the submission type
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
public class ErrorSubmission<T extends Submission>
{
    /**
     * The unique ID of the submission causing the error. If the error occurred
     * while making the initial submission, this field will receive the ID that
     * the negotiator would have otherwise given the submission. Otherwise, the
     * value of this field will replicate the ID of the registered submission.
     */
    private int id;
    /**
     * The stage of processing at which the error occurred. In the case of a
     * component self-reporting a failure, this will be the capability of the
     * component itself; otherwise, the negotiator will indicate the capability
     * type of the component which caused the error.
     */
    private CapabilityType stage;
    /**
     * The type of error which has occurred.
     */
    private ErrorType type;
    /**
     * An error message.
     */
    @JsonInclude(Include.NON_NULL)
    private String message;

    /**
     * The submission causing the error.
     */
    private T submission;
}