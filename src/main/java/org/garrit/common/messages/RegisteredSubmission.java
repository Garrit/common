package org.garrit.common.messages;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A registerd submission is a {@link Submission} which has been given an ID.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisteredSubmission extends Submission
{
    /**
     * A unique ID for the submission.
     */
    private int id;

    public RegisteredSubmission()
    {
        super();
    }

    public RegisteredSubmission(Submission submission)
    {
        super(submission);
    }
}