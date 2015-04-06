package org.garrit.common.messages;

import lombok.Data;

/**
 * The results of an execution.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
public class ExecutionCase
{
    /**
     * The name of the case.
     */
    private String name;
    /**
     * How long the case took to evaluate.
     */
    private int runtime;
    /**
     * The output of the submission for the case.
     */
    private byte[] output;

    public ExecutionCase()
    {
    }

    public ExecutionCase(ExecutionCase executionCase)
    {
        this.name = executionCase.name;
        this.runtime = executionCase.runtime;
        this.output = executionCase.output;
    }
}