package ru.sbrf.server.processing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sbrf.server.common.messages.ResponseException;
import ru.sbrf.server.processing.exception.AccountNotFoundException;
import ru.sbrf.server.processing.exception.CardNotFoundException;
import ru.sbrf.server.processing.exception.UserNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class HostRestControllerAdvice {

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ResponseException> processValidationErrorCard(CardNotFoundException exception) {
        String message = String.format("%s %s", LocalDateTime.now(), exception.getMessage());
        ResponseException responseException = new ResponseException(message);
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseException> processValidationErrorUser(UserNotFoundException exception) {
        String message = String.format("%s %s", LocalDateTime.now(), exception.getMessage());
        ResponseException responseException = new ResponseException(message);
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ResponseException> processValidationErrorAccount(AccountNotFoundException exception) {
        String message = String.format("%s %s", LocalDateTime.now(), exception.getMessage());
        ResponseException responseException = new ResponseException(message);
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }
}
