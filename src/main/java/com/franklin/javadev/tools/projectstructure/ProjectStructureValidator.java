package com.franklin.javadev.tools.projectstructure;

import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectStructureValidator {

    private static final List<String> REQUIRED_PATHS = List.of(
            "pom.xml",
            "src",
            "src/main",
            "src/main/java",
            "src/test",
            "src/test/java"
    );

    public List<String> findMissingPaths(Path projectRoot) {
        List<String> missingPaths = new ArrayList<>();

        for (String requiredPath : REQUIRED_PATHS) {
            if (!Files.exists(projectRoot.resolve(requiredPath))) {
                missingPaths.add(requiredPath);
            }
        }

        return missingPaths;
    }
}