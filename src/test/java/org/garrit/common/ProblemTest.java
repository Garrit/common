package org.garrit.common;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ProblemTest
{
    /**
     * The path to a file containing a problem definition.
     */
    private static final String PROBLEM_PATH = "../problems/echo/problem.json";

    @Test
    public void testProblemFromFile() throws IOException
    {
        Problem problem = Problem.fromFile(new File(PROBLEM_PATH));

        assertNotNull(problem.getDescription());

        for (ProblemSample problemSample : problem.getSamples())
        {
            assertNotNull(problemSample.getInput());
            assertNotNull(problemSample.getOutput());
        }

        for (ProblemCase problemCase : problem.getCases())
        {
            assertNotNull(problemCase.getInput());
            assertNotNull(problemCase.getOutput());
        }
    }
}