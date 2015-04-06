package org.garrit.common.messages;

/**
 * The very broad categories of errors which can occur throughout the stages of
 * processing of a submission.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public enum ErrorType
{
    /**
     * An error which doesn't fit into any of the other defined categories.
     */
    E_OTHER,
    /**
     * An error caused by an internal malfunction of the component.
     */
    E_INTERNAL,
    /**
     * A failure during submission compilation.
     */
    E_COMPILATION,
    /**
     * A failure occurring during submission execution.
     */
    E_RUNTIME,
    /**
     * A failure while judging the submission.
     */
    E_JUDGING
}