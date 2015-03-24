package org.garrit.common;

import lombok.Data;

/**
 * A file part of a submission.
 * 
 * <code>{@link SubmissionFile#contents}</code> is Base64-encoded in the JSON
 * message. <a href="https://github.com/FasterXML/jackson-databind/">Jackson</a>
 * will automatically marshal to/from Base64 when serializing/deserializing.
 * 
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
public class SubmissionFile
{
    /**
     * The name of the file as a relative path. The execution environment may
     * place the collection of submission files wherever it sees fit within the
     * executing system, but all submission files will be stored relative to
     * each other.
     */
    private String filename;
    /**
     * The contents of the file.
     */
    private byte contents[];
}