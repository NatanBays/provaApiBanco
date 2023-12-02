package org.senai.ecommerce.servico;

import org.senai.ecommerce.entities.Usuario;
import org.senai.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    UserRepository userRepository;

    @Override
    public Usuario create(Usuario user) {
        Usuario existUser = userRepository.findByUsername(user.getUsername());

        if(existUser != null){
            throw new Error("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        Usuario createdUser = userRepository.save(user);

        return createdUser;
    }
}