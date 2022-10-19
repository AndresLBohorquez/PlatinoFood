package com.platinosfood.backend.repositories;

import com.platinosfood.backend.entities.Orden;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {

    public List<Orden> findAllByUserId(int userId);
}
