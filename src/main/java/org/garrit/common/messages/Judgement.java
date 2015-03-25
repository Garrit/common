package org.garrit.common.messages;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A submission which has passed through judgement.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Judgement extends Execution
{
    /**
     * Cases evaluated during the judgement.
     */
    private List<ExecutionCase> cases;
}