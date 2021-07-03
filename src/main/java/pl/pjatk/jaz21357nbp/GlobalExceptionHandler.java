package pl.pjatk.jaz21357nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Upstream Service returned 404.")
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public void handle404(HttpClientErrorException ex) {
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Upstream Service returned 400. Incorrect request")
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public void handle400(HttpClientErrorException ex) {
    }
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT, reason = "Upstream Service Not Responding, Try Again")
    @ExceptionHandler(ConnectException.class)
    public void handleConnEx(ConnectException ex) {
    }
}
