package org.garrit.common;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A problem definition.
 * 
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Problem
{
    /**
     * The name of the file within a problem directory which defines the
     * parameters of the problem.
     */
    protected static final String PROBLEM_DEFINITION = "problem.json";

    /**
     * The name of the problem.
     */
    private String name;
    /**
     * The problem description.
     */
    private byte[] description;
    /**
     * The name of a file containing the problem description.
     */
    private String descriptionFile;
    /**
     * The default execution time limit for all problem cases.
     */
    private Integer timeLimit;
    /**
     * The default execution memory limit for all problem cases.
     */
    private Integer memoryLimit;
    /**
     * The sample cases for the problem.
     */
    private List<ProblemSample> samples = new ArrayList<>();
    /**
     * The secret judging cases for the problem.
     */
    private List<ProblemCase> cases = new ArrayList<>();
}