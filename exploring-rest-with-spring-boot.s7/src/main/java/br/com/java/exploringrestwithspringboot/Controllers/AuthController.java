package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.Services.AuthServices;
import br.com.java.exploringrestwithspringboot.VO.v1.AccountCredentialsVOv1;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthServices authServices;

    private @NotNull Boolean validateDate(AccountCredentialsVOv1 data) {
        return data == null || data.getUsername() == null || data.getUsername().isBlank() || data.getPassword() == null || data.getPassword().isBlank();
    }

    @SuppressWarnings("rawtypes")
    @Operation(summary = "Authenticates an user and returns one token.")
    @PostMapping(value = "/signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsVOv1 data) {
        if (validateDate(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        var token = authServices.signin(data);

        if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        return token;
    }
}
