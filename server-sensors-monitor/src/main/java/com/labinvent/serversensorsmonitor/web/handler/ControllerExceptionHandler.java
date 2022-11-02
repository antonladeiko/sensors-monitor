package com.labinvent.serversensorsmonitor.web.handler;

import com.labinvent.serversensorsmonitor.exceptions.NotFoundException;
import com.labinvent.serversensorsmonitor.web.response.BaseWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseWebResponse> handleNotFoundException(NotFoundException exception){
        log.error(exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BaseWebResponse(exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseWebResponse> handleValidationExceptions(MethodArgumentNotValidException exception){
        log.error(exception.getMessage());

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BaseWebResponse(errors.toString()));
    }
}
