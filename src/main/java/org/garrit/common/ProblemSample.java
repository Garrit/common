package org.garrit.common;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A sample input/output case for a problem.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ProblemSample
{
    /**
     * The name of the sample case.
     */
    private String name;
    /**
     * The sample input.
     */
    private byte[] input;
    /**
     * The name of a file containing sample input.
     */
    private String inputFile;
    /**
     * The sample output.
     */
    private byte[] output;
    /**
     * The name of a file containing sample output.
     */
    private String outputFile;
}