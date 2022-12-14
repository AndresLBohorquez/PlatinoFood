package com.platinosfood.backend.services.impl;

import com.platinosfood.backend.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.platinosfood.backend.repositories.UsuarioRepository;
import com.platinosfood.backend.services.UsuarioService;
import com.platinosfood.backend.util.DateHour;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private UsuarioService usuarioService;

    DateHour dh = new DateHour();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = userRepository.findByUsername(username);

        if (us != null) {
            var usuLog = us;
            usuLog.setAccessDate(dh.date() + " " + dh.hour());
            usuarioService.editUser(usuLog);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(us.getRole().getName()));

        UserDetails userDetails = new User(us.getEmail(), us.getPassword(), roles);

        return userDetails;
    }

}
