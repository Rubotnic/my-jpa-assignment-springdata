package se.lexicon.myjpaassignmentspringdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    private Map<String, Object> build(HttpStatus status, Exception ex, WebRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        response.put("value", status.value());
        response.put("name", status.name());
        response.put("message", ex.getMessage());
        return response;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleAppResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return build(HttpStatus.NOT_FOUND, ex, request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(build(HttpStatus.BAD_REQUEST, ex, request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {

        Map<String, String> violationList = new HashMap<>();
        for (FieldError err : ex.getBindingResult().getFieldErrors()) {
            violationList.put(err.getField(), err.getDefaultMessage());
        }

        Map<String, Object> response = build(HttpStatus.BAD_REQUEST, ex, request);
        response.put("violation", violationList);

        return response;
    }
}
