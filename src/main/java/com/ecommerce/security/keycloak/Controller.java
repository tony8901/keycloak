package com.ecommerce.security.keycloak;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    @GetMapping("/secure")
    public ResponseEntity<?> response(){
        return ResponseEntity.status(HttpStatus.OK).body("Secure resource!!");
    }

    @GetMapping("/")
    public ResponseEntity<?> home(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello world!");
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }
}
