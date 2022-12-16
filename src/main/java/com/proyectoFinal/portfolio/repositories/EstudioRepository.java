package com.proyectoFinal.portfolio.repositories;
import com.proyectoFinal.portfolio.models.EstudioModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository<EstudioModel, Long>{
    //Creo método para luego llamarlo en el Service, en "getEstudioByTitulo".
                                            //findBy... + parámetro.
    public abstract List<EstudioModel> findByTitulo(String titulo);
}
