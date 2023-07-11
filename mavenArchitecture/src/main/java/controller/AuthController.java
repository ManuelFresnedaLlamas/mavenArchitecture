package controller;

import models.Auth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class AuthController {
    @GetMapping(value = "/api/auth")
    public ResponseEntity<Auth> user(){
        Auth ret = new Auth("login", "passh", "passs", "passr", 1, UUID.randomUUID());
        return ResponseEntity.ok(ret);
    }
}
