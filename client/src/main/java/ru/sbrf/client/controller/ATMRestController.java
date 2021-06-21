package ru.sbrf.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import ru.sbrf.client.exception.ATMInternalErrorException;
import ru.sbrf.server.common.messages.Request;
import ru.sbrf.server.common.messages.RequestTypes;
import ru.sbrf.server.common.messages.Response;

import java.io.IOException;

@RestController
@AllArgsConstructor
@Log
public class ATMRestController {

    @GetMapping("/ATMs")
    public String getATMsStatus() {
        return "1 ATM is ready.";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/ATMs/{ATMId}/operation/balance/{cardNumber}/{expirationDate}/{PIN}/{CVV}")
    public String getUserBalance(
            @PathVariable("ATMId") int ATMId,
            @PathVariable("cardNumber") String cardNumber,
            @PathVariable("expirationDate") String expirationDate,
            @PathVariable("PIN") int PIN,
            @PathVariable("CVV") int CVV) throws IOException {

        log.info("ATMId " + ATMId + " cardNumber " + cardNumber + " expirationDate " + expirationDate + " PIN " + PIN + " CVV " + CVV);

        if (ATMId != 1) {
            throw new ATMInternalErrorException("ATM internal Error");
        }

        Request request = new Request(cardNumber, expirationDate, PIN, CVV, RequestTypes.JSON);

        WebClient webClient = WebClient.create();
        Response resp = webClient
                .post()
                .uri("http://127.0.0.1:8080/balance")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), Request.class)
                .retrieve()
                .bodyToMono(Response.class)
                .block();

        assert resp != null;
        log.info(resp.toString());

        return resp.toString();
    }

    @ExceptionHandler(WebClientResponseException.class)
    public String handleWebClientResponseException(WebClientResponseException ex) {
        log.info("Error from WebClient - " + ex.getStatusText() + ex.getResponseBodyAsString());
        return "Error from WebClient - " + ex.getStatusText() + ex.getResponseBodyAsString();
    }
}

