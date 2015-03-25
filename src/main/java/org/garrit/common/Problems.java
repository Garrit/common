package org.garrit.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility methods for dealing with {@link Problem problems}.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public class Problems
{

    /**
     * Read in a problem definition from a file. Additionally reads the
     * description and case inputs/outputs from files, if applicable.
     * 
     * @param problemFile the file containing the problem definition
     * @return the problem definition
     * @throws IOException if an error occurs while reading from the file
     */
    public static Problem fromFile(File problemFile) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Problem problem = mapper.readValue(problemFile, Problem.class);

        if (problem.getDescriptionFile() != null)
        {
            Path descriptionPath = Paths.get(problemFile.getParent(), problem.getDescriptionFile());
            problem.setDescription(Files.readAllBytes(descriptionPath));
        }

        for (ProblemSample problemSample : problem.getSamples())
        {
            if (problemSample.getInputFile() != null)
            {
                Path inputPath = Paths.get(problemFile.getParent(), problemSample.getInputFile());
                problemSample.setInput(Files.readAllBytes(inputPath));
            }

            if (problemSample.getOutputFile() != null)
            {
                Path outputPath = Paths.get(problemFile.getParent(), problemSample.getOutputFile());
                problemSample.setOutput(Files.readAllBytes(outputPath));
            }
        }

        for (ProblemCase problemCase : problem.getCases())
        {
            if (problemCase.getInputFile() != null)
            {
                Path inputPath = Paths.get(problemFile.getParent(), problemCase.getInputFile());
                problemCase.setInput(Files.readAllBytes(inputPath));
            }

            if (problemCase.getOutputFile() != null)
            {
                Path outputPath = Paths.get(problemFile.getParent(), problemCase.getOutputFile());
                problemCase.setOutput(Files.readAllBytes(outputPath));
            }
        }

        return problem;
    }

    /**
     * Get a problem by its name.
     * 
     * @param problems the path containing all problems
     * @param name the name of the problem
     * @return the problem
     * @throws IOException if the problem does not exist, or if an error occurs
     *             while reading it
     */
    public static Problem problemByName(Path problems, String name) throws IOException
    {
        File problemFile = problems.resolve(name).resolve(Problem.PROBLEM_DEFINITION).toFile();
        return Problems.fromFile(problemFile);
    }
}