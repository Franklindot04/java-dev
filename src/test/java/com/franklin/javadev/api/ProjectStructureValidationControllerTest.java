package com.franklin.javadev.api;

import com.franklin.javadev.tools.projectstructure.ProjectStructureValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Path;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectStructureValidationController.class)
class ProjectStructureValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProjectStructureValidator validator;

    @Test
    void validateReturnsValidResponse() throws Exception {
        when(validator.findMissingPaths(any(Path.class)))
                .thenReturn(List.of());

        mockMvc.perform(post("/api/v1/tools/project-structure/validate")
                        .contentType("application/json")
                        .content("""
                                {
                                  "path": "/tmp/example-project"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.valid").value(true))
                .andExpect(jsonPath("$.missing").isEmpty())
                .andExpect(jsonPath("$.message").value("Project structure is valid"));
    }

    @Test
    void validateReturnsIncompleteResponse() throws Exception {
        when(validator.findMissingPaths(any(Path.class)))
                .thenReturn(List.of("pom.xml", "src/test/java"));

        mockMvc.perform(post("/api/v1/tools/project-structure/validate")
                        .contentType("application/json")
                        .content("""
                                {
                                  "path": "/tmp/example-project"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.valid").value(false))
                .andExpect(jsonPath("$.missing").isNotEmpty())
                .andExpect(jsonPath("$.message").value("Project structure is incomplete"));
    }
}