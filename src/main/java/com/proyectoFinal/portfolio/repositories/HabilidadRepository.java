package com.proyectoFinal.portfolio.repositories;

import com.proyectoFinal.portfolio.models.HabilidadModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository <HabilidadModel, Long> {
    //Creo método para luego llamarlo en el Service, en "getHabilidadByTipo".
                                            //findBy... + parámetro.
    public abstract List<HabilidadModel>findByTipo(String tipo);
}
