package com.jm.apistudent.utils;

import com.jm.apistudent.exception.EmailAlreadyExistsException;
import com.jm.apistudent.utils.ErrorResponse;
import com.jm.apistudent.exception.NotFoundException;
import com.jm.apistudent.utils.ErrorCatalog;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.STUDENT_NOT_FOUND.getCode())
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();

        return ErrorResponse.builder()
                .code(ErrorCatalog.INVALID_STUDENT.getCode())
                .status(HttpStatus.BAD_REQUEST)
                .message(ErrorCatalog.INVALID_STUDENT.getMessage())
                .detailMessages(result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception ex) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .detailMessages(Collections.singletonList(ex.getMessage()))
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ErrorResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.STUDENT_EMAIL_ALREADY_EXISTS.getCode())
                .status(HttpStatus.CONFLICT)
                .message(ex.getMessage())
                .detailMessages(Collections.emptyList())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}