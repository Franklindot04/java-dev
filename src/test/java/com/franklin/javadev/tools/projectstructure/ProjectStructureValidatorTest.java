package com.franklin.javadev.tools.projectstructure;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectStructureValidatorTest {

    private final ProjectStructureValidator validator = new ProjectStructureValidator();

    @Test
    void validProjectStructureHasNoMissingPaths() throws IOException {
        Path projectRoot = Files.createTempDirectory("java-dev-valid-project");

        try {
            createRequiredStructure(projectRoot);

            List<String> missingPaths = validator.findMissingPaths(projectRoot);

            assertEquals(List.of(), missingPaths);
        } finally {
            deleteRecursively(projectRoot);
        }
    }

    @Test
    void incompleteProjectStructureReportsMissingPaths() throws IOException {
        Path projectRoot = Files.createTempDirectory("java-dev-incomplete-project");

        try {
            Files.createDirectories(projectRoot.resolve("src/main/java"));

            List<String> missingPaths = validator.findMissingPaths(projectRoot);

            assertEquals(
                    List.of(
                            "pom.xml",
                            "src/test",
                            "src/test/java"
                    ),
                    missingPaths
            );
        } finally {
            deleteRecursively(projectRoot);
        }
    }

    private void createRequiredStructure(Path projectRoot) throws IOException {
        Files.createFile(projectRoot.resolve("pom.xml"));
        Files.createDirectories(projectRoot.resolve("src/main/java"));
        Files.createDirectories(projectRoot.resolve("src/test/java"));
    }

    private void deleteRecursively(Path path) throws IOException {
        try (var paths = Files.walk(path)) {
            paths.sorted((first, second) -> second.compareTo(first))
                    .forEach(currentPath -> {
                        try {
                            Files.delete(currentPath);
                        } catch (IOException exception) {
                            throw new RuntimeException(exception);
                        }
                    });
        }
    }
}