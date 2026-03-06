package com.capgemini.url_shortener.exception;



import com.capgemini.url_shortener.dto.ErrorResponseDto;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ShortCodeNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleShortCodeNotFound(ShortCodeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDto.builder()
                        .timestamp(LocalDateTime.now())
                        .status(404)
                        .message(ex.getMessage())
                        .build());
    }

    @ExceptionHandler(ShortCodeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleShortCodeConflict(ShortCodeAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponseDto.builder()
                        .timestamp(LocalDateTime.now())
                        .status(409)
                        .message(ex.getMessage())
                        .build());
    }
}
