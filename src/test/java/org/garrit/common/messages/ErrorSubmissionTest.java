package org.garrit.common.messages;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.garrit.common.messages.statuses.CapabilityType;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test that error messages can be generated correctly.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public class ErrorSubmissionTest
{
    @Test
    public void testWithErrorMessage() throws IOException
    {
        RegisteredSubmission submission = new RegisteredSubmission();
        submission.setId(0);
        submission.setLanguage("whatever");
        submission.setProblem("something");
        submission.setEntryPoint("dunno");

        ErrorSubmission<Submission> error = new ErrorSubmission<>();
        error.setId(0);
        error.setStage(CapabilityType.EXECUTOR);
        error.setType(ErrorType.E_INTERNAL);
        error.setMessage("Something bad happened");
        error.setSubmission(submission);

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(error);

        assertEquals(
                "{\"id\":0,\"stage\":\"executor\",\"type\":\"E_INTERNAL\",\"message\":\"Something bad happened\",\"submission\":{\"language\":\"whatever\",\"problem\":\"something\",\"files\":[],\"entryPoint\":\"dunno\",\"id\":0}}",
                serialized);
    }

    @Test
    public void testNullErrorMessage() throws IOException
    {
        RegisteredSubmission submission = new RegisteredSubmission();
        submission.setId(0);
        submission.setLanguage("whatever");
        submission.setProblem("something");
        submission.setEntryPoint("dunno");

        ErrorSubmission<Submission> error = new ErrorSubmission<>();
        error.setId(0);
        error.setStage(CapabilityType.EXECUTOR);
        error.setType(ErrorType.E_INTERNAL);
        error.setSubmission(submission);

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(error);

        assertEquals(
                "{\"id\":0,\"stage\":\"executor\",\"type\":\"E_INTERNAL\",\"submission\":{\"language\":\"whatever\",\"problem\":\"something\",\"files\":[],\"entryPoint\":\"dunno\",\"id\":0}}",
                serialized);
    }
}