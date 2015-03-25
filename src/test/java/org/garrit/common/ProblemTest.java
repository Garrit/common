package org.garrit.common;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ProblemTest
{
    /**
     * The path to a directory containing a problem definitions.
     */
    private static final Path PROBLEMS_PATH = Paths.get("../problems");
    /**
     * The name of a problem known to exist.
     */
    private static final String EXAMPLE_PROBLEM = "echo";

    @Test
    public void testProblemFromFile() throws IOException
    {
        Path problemPath = PROBLEMS_PATH.resolve(EXAMPLE_PROBLEM).resolve(Problem.PROBLEM_DEFINITION);
        Problem problem = Problems.fromFile(problemPath.toFile());

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

    @Test
    public void testProblemByName() throws IOException
    {
        Problems.problemByName(PROBLEMS_PATH, EXAMPLE_PROBLEM);
    }
}