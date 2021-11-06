package com.reda.gestionStockR1.handlers;

import com.reda.gestionStockR1.exception.InvalidEntityException2;
import com.reda.gestionStockR1.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice // pour ne pas besoin d'ajouter @RquestBoddy a chaque methode
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorsDto> handleExceptionNotFount(NotFoundException exception, WebRequest webRequest){

        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        final ErrorsDto errorCodes = ErrorsDto.builder()
                .httpCode(notFound.value())
                .errorsCode(exception.getErrorsCode())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorCodes, notFound);
    }

    @ExceptionHandler(InvalidEntityException2.class)
    public ResponseEntity<ErrorsDto> handleExceptionInvalid(InvalidEntityException2 exception, WebRequest webRequest){

        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorsDto errorCodes = ErrorsDto.builder()
                .httpCode(badRequest.value())
                .errorsCode(exception.getErrorsCode())
                .message(exception.getMessage())
                .errorsList(exception.getErrorsList())
                .build();

        return new ResponseEntity<>(errorCodes, badRequest);
    }
}
