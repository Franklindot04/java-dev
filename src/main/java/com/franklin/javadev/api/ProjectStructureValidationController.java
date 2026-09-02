package com.franklin.javadev.api;

import com.franklin.javadev.tools.projectstructure.ProjectStructureValidator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tools/project-structure")
public class ProjectStructureValidationController {

    private final ProjectStructureValidator validator;

    public ProjectStructureValidationController(ProjectStructureValidator validator) {
        this.validator = validator;
    }

    @PostMapping("/validate")
    public ProjectStructureValidationResponse validate(
            @RequestBody ProjectStructureValidationRequest request) {

        List<String> missingPaths =
                validator.findMissingPaths(Path.of(request.path()));

        boolean valid = missingPaths.isEmpty();

        String message = valid
                ? "Project structure is valid"
                : "Project structure is incomplete";

        return new ProjectStructureValidationResponse(
                valid,
                missingPaths,
                message
        );
    }
}