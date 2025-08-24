package com.github.ediel_queiroz.breadthfirstsearch.presentation;

import jakarta.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Map<String, Object>> handleConstraintViolation(
      ConstraintViolationException ex) {
    List<Map<String, String>> violations = ex.getConstraintViolations().stream()
        .map(v -> Map.of(
            "property", v.getPropertyPath().toString(),
            "message", v.getMessage()
        ))
        .toList();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(Map.of(
            "error", "Validation failed",
            "violations", violations
        ));
  }

}
