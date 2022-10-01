package com.platinosfood.backend.repositories;


import com.platinosfood.backend.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
