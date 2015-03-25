package org.garrit.common.messages;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A submission which has passed through execution.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Execution extends RegisteredSubmission
{
    /**
     * Cases evaluated during the execution.
     */
    private List<ExecutionCase> cases;
}