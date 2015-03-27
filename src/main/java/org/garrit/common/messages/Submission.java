package org.garrit.common.messages;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Represents a submission to the system.
 * 
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
public class Submission
{
    /**
     * The language in which the submission is written.
     */
    private String language;
    /**
     * The identifier of the problem targetted by the submission.
     */
    private String problem;
    /**
     * All files required for the submission.
     */
    private List<SubmissionFile> files = new ArrayList<>();
    /**
     * An identifier serving as the main entry point for the submission. What
     * exactly constitutes the main entry point for the submission will depend
     * on the submission language; for Java programs, this is the name of
     * the class containing the <code>main</code> method to be executed; for
     * Python programs, this is the filename of the main script; for C/C++
     * programs, this could be anything, as the linker will determine the point
     * of entry.
     */
    private String entryPoint;

    public Submission()
    {
    }

    public Submission(Submission submission)
    {
        this.language = submission.language;
        this.problem = submission.problem;
        this.files = new ArrayList<>(submission.files);
        this.entryPoint = submission.entryPoint;
    }
}