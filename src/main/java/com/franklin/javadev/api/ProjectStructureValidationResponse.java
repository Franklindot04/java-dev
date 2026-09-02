package com.franklin.javadev.api;

import java.util.List;

public record ProjectStructureValidationResponse(
        boolean valid,
        List<String> missing,
        String message
) {
}