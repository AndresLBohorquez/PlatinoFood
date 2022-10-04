package com.platinosfood.backend.services;

import com.platinosfood.backend.entities.User;
import java.util.List;

public interface UserService {

    public List<User> getUsers();
    
    public User getUserById(int id);
    
    public User addUser(User user);
    
    public User editUser(User user);
    
    public void deleteUser(int id);
}
