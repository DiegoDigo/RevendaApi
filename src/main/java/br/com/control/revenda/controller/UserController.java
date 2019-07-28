package br.com.control.revenda.controller;

import br.com.control.revenda.entity.UserApplication;
import br.com.control.revenda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {


    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping()
    public ResponseEntity signUp(@RequestBody UserApplication user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.save(user));
    }

}
