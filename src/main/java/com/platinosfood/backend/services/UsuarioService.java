package com.platinosfood.backend.services;

import com.platinosfood.backend.entities.Usuario;
import java.util.List;

public interface UsuarioService {

    public List<Usuario> getUsers();

    public Usuario getUserById(int id);

    public Usuario addUser(Usuario user);

    public Usuario editUser(Usuario user);

    public void deleteUser(int id);

    public Usuario getUsuarioByUsername(String username);

}
