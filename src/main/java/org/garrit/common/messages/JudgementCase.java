package org.garrit.common.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The results of a judgement.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class JudgementCase extends ExecutionCase
{
    /**
     * A numeric value representing the judgement. Context for this value is
     * provided by <code>{@link JudgementCase#valueMin}</code>/
     * <code>{@link JudgementCase#valueMax}</code>.
     */
    private int value;
    /**
     * A minimum value for <code>{@link JudgementCase#value}</code>.
     */
    private int valueMin;
    /**
     * A maximum value for <code>{@link JudgementCase#value}</code>.
     */
    private int valueMax;
    /**
     * Any judgement notes may be given here.
     */
    @JsonInclude(Include.NON_NULL)
    private String notes;

    public JudgementCase()
    {
        super();
    }

    public JudgementCase(ExecutionCase executionCase)
    {
        super(executionCase);
    }
}