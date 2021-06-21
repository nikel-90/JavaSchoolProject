package ru.sbrf.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.server.common.messages.Request;
import ru.sbrf.server.common.messages.Response;
import ru.sbrf.server.processing.model.transfer.CardDTO;
import ru.sbrf.server.processing.service.CardService;

@RestController
@AllArgsConstructor
@Log
public class HostRestController {
    private final CardService cardService;

    @GetMapping("/hosts")
    public String getHostsInfo() {
        return "{data: \"1 host available\"}";
    }


    @GetMapping("/hosts/{hostId}")
    public String getHostInfo(@PathVariable Long hostId) {
        if (hostId == 1) {
            return "{data: \"Host " + hostId + " ready\"}";
        } else {
            return "{data: \"Host " + hostId + " not ready\"}";
        }
    }

    @PostMapping(value = "/balance",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBalance(@RequestBody Request request) throws JSONException {
        Response response = null;
        CardDTO cardDTO = cardService.getCardByCardNumber(request.getCardNumber());

        if (cardDTO.getExpirationDate().equals(request.getExpirationDate()) && cardDTO.getPIN() == request.getPIN() && cardDTO.getCVV() == request.getCVV()) {
            response = new Response("Ваш баланс: ", cardDTO.getAccount_id().getAccountBalance());
        }

        log.info(response.toString());

        return response;
    }
}


