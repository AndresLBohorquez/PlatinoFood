package com.platinosfood.backend.services.impl;

import com.platinosfood.backend.entities.Orden;
import com.platinosfood.backend.repositories.OrdenRepository;
import com.platinosfood.backend.services.OrdenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenServiceImpl implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> getOrdenes() {
        return ordenRepository.findAll();
    }

     @Override
    public Orden addOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public List<Orden> getOrdenesByIdUsuario(int idUsuario) {
     return ordenRepository.findAllByUserId(idUsuario);
    }

}
