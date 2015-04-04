package org.garrit.common.messages;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test that {@link SubmissionFile} objects are correctly
 * serialized/deserialized to/from JSON.
 * 
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public class SubmissionFileTest
{
    private static final String SERIALIZED_FILE = "{\"filename\":\"test\",\"contents\":\"SGVsbG8gd29ybGQ=\"}";
    private static final byte FILE_CONTENTS[] = "Hello world".getBytes();

    @Test
    public void testBase64Decode() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        SubmissionFile submissionFile = mapper.readValue(SERIALIZED_FILE, SubmissionFile.class);

        assertEquals("test", submissionFile.getFilename());
        assertArrayEquals(FILE_CONTENTS, submissionFile.getContents());
    }

    @Test
    public void testBase64Encode() throws IOException
    {
        SubmissionFile submissionFile = new SubmissionFile();
        submissionFile.setFilename("test");
        submissionFile.setContents(FILE_CONTENTS);

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(submissionFile);

        assertEquals(SERIALIZED_FILE, serialized);
    }
}