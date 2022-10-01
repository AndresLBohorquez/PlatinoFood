package com.platinosfood.backend.services.impl;

import com.platinosfood.backend.entities.Role;
import com.platinosfood.backend.repositories.RoleRepository;
import com.platinosfood.backend.services.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();

    }

}
