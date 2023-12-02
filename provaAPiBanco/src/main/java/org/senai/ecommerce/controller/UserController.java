package org.senai.ecommerce.controller;

import org.senai.ecommerce.entities.Usuario;
import org.senai.ecommerce.servico.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping
    public Usuario create(@RequestBody Usuario user){
        return userService.create(user);
    }

}
