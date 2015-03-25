package org.garrit.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.LinkedList;

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

    /**
     * Retrieve all problems available in a directory.
     * 
     * @param problems the path containing all problems
     * @return a list of the names of all available problems
     * @throws IOException if an error occurs finding problems
     */
    public static LinkedList<String> availableProblems(Path problems) throws IOException
    {
        String problemPattern = "glob:" + problems.toString() + "/*/" + Problem.PROBLEM_DEFINITION;
        PathMatcher matcher = problems.getFileSystem().getPathMatcher(problemPattern);

        LinkedList<String> names = new LinkedList<>();
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
            {
                if (matcher.matches(file))
                    names.add(file.getParent().getFileName().toString());

                return super.visitFile(file, attrs);
            }
        };

        /* Walk the file tree just deep enough to find problem definitions the
         * next folder down. */
        Files.walkFileTree(problems, EnumSet.noneOf(FileVisitOption.class), 2, visitor);

        return names;
    }
}