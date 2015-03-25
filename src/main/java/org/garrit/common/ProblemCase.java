package org.garrit.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * An input/output case for a problem. These are defined the same as
 * {@link ProblemSample sample problems}, with additional properties defining
 * time/memory limits.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ProblemCase extends ProblemSample
{
    /**
     * A case-specific execution time limit.
     */
    private Integer timeLimit;
    /**
     * A case-specific execution memory limit.
     */
    private Integer memoryLimit;
}