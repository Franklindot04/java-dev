package com.franklin.javadev.api;

public record StatusResponse(
        String service,
        String status
) {
}