package com.platinosfood.backend.services.impl;

import com.platinosfood.backend.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.platinosfood.backend.repositories.UsuarioRepository;
import com.platinosfood.backend.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public List<Usuario> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Usuario addUser(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public Usuario editUser(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Usuario getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Usuario getUsuarioByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
