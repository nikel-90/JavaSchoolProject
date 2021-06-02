package ru.sbrf.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.server.processing.service.UserService;


@RestController
@AllArgsConstructor
@Log
public class HostRestController {
    private UserService userService;

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

//    @GetMapping("/hosts/{hostId}/clients")
//    public List<UserDTO> getClientsInfo(@PathVariable Long hostId) {
//        if (hostId != 1) {
//            throw new UserNotFoundException();
//        }
//        return userService.getAllUsers();
//    }

//    @PostMapping("/hosts/{hostId}/clients/{clientId}")
//    public Response getBalance(@PathVariable("hostId") Long hostId,
//                               @PathVariable("clientId") Long clientId,
//                               @RequestBody Request request) {
//        if (hostId != 1) {
//            throw new RuntimeException("Host " + hostId + " is not ready!");
//        }
//
//        log.info(request.toString());
//        Response response = new Response(clientService.getClient(clientId).getAccountDTO().get(0).getBalance());
//        log.info(response.toString());
//        return response;
//    }
}


