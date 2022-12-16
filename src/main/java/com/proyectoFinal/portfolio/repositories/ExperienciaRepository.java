package com.proyectoFinal.portfolio.repositories;
import com.proyectoFinal.portfolio.models.ExperienciaModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<ExperienciaModel, Long>{
    //Creo método para luego llamarlo en el Service, en "getExperienciaByInstitucion".
                                            //findBy... + parámetro.
    public abstract List<ExperienciaModel> findByInstitucion(String institucion);
}
