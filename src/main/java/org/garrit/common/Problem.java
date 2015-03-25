package org.garrit.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A problem definition.
 * 
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Problem
{
    /**
     * The name of the problem.
     */
    private String name;
    /**
     * The problem description.
     */
    private byte[] description;
    /**
     * The name of a file containing the problem description.
     */
    private String descriptionFile;
    /**
     * The default execution time limit for all problem cases.
     */
    private Integer timeLimit;
    /**
     * The default execution memory limit for all problem cases.
     */
    private Integer memoryLimit;
    /**
     * The sample cases for the problem.
     */
    private List<ProblemSample> samples;
    /**
     * The secret judging cases for the problem.
     */
    private List<ProblemCase> cases;

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
}