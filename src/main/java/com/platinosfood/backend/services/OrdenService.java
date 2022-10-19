package com.platinosfood.backend.services;

import com.platinosfood.backend.entities.Orden;
import java.util.List;

public interface OrdenService {

    public List<Orden> getOrdenes();

    public List<Orden> getOrdenesByIdUsuario(int idUsuario);
    
    public Orden addOrden(Orden orden);
}
