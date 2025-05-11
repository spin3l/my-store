package com.spin3l.store.api.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message
) {

    public static ErrorResponse create(
            int status,
            String error,
            String message
    ) {
        return new ErrorResponse(
                LocalDateTime.now(),
                status,
                error,
                message
        );
    }
}
