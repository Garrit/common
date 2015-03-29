package org.garrit.common.messages.statuses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test that {@link Status} objects are correctly
 * serialized/deserialized to/from JSON.
 * 
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public class StatusTest
{
    @Test
    public void testEmptyCapabilities() throws IOException
    {
        Status status = new Status("empty service");

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(status);

        assertEquals(
                "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{}}",
                serialized);
    }

    @Test
    public void testExecutorCapabilities() throws IOException
    {
        Status status = new Status("empty service");
        ExecutorStatus executor = new ExecutorStatus()
        {
            @Override
            public Iterable<String> getLanguages()
            {
                return Arrays.asList("piglatin");
            }

            @Override
            public Iterable<String> getProblems()
            {
                return Arrays.asList("hard");
            }

            @Override
            public Iterable<Integer> getQueued()
            {
                return Arrays.asList();
            }
        };

        status.setCapabilityStatus(executor);

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(status);

        assertEquals(
                "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{\"executor\":{\"languages\":[\"piglatin\"],\"problems\":[\"hard\"],\"queued\":[]}}}",
                serialized);
    }

    @Test
    public void testJudgeCapabilities() throws IOException
    {
        Status status = new Status("empty service");
        JudgeStatus executor = new JudgeStatus()
        {
            @Override
            public Iterable<String> getLanguages()
            {
                return Arrays.asList("elbonian");
            }

            @Override
            public Iterable<String> getProblems()
            {
                return Arrays.asList("several");
            }

            @Override
            public Iterable<Integer> getQueued()
            {
                return Arrays.asList();
            }
        };

        status.setCapabilityStatus(executor);

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(status);

        assertEquals(
                "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{\"judge\":{\"languages\":[\"elbonian\"],\"problems\":[\"several\"],\"queued\":[]}}}",
                serialized);
    }

    @Test
    public void testReporterCapabilities() throws IOException
    {
        Status status = new Status("empty service");
        status.setCapabilityStatus(new ReporterStatus()
        {
        });

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(status);

        assertEquals(
                "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{\"reporter\":{}}}",
                serialized);
    }

    @Test
    public void testNegotiatorCapabilities() throws IOException
    {
        Status status = new Status("empty service");
        status.setCapabilityStatus(new NegotiatorStatus()
        {
        });

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(status);

        assertEquals(
                "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{\"negotiator\":{}}}",
                serialized);
    }

    @Test
    public void testReporterAndNegotiatorCapabilities() throws IOException
    {
        Status status = new Status("empty service");
        status.setCapabilityStatus(new ReporterStatus()
        {
        });
        status.setCapabilityStatus(new NegotiatorStatus()
        {
        });

        ObjectMapper mapper = new ObjectMapper();
        String serialized = mapper.writeValueAsString(status);

        String orderA = "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{\"reporter\":{},\"negotiator\":{}}}";
        String orderB = "{\"name\":\"empty service\",\"uptime\":0,\"provides\":{\"negotiator\":{},\"reporter\":{}}}";
        HashSet<String> expected = new HashSet<>();
        expected.add(orderA);
        expected.add(orderB);

        assertTrue(expected.contains(serialized));
    }
}