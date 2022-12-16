package com.proyectoFinal.portfolio.Interface;

import com.proyectoFinal.portfolio.models.ExperienciaModel;
import java.util.List;

public interface ExperienciaInterface {
    //Traer Experiencia
    public List<ExperienciaModel> getExperiencias();
    
    //Guardar Experiencia
    public void saveExperiencia(ExperienciaModel exp);
    
    //Eliminar Experiencia por id
    public void deleteExperiencia (Long id);
    
    //Buscar Experiencia por id
    public ExperienciaModel findExperiencia(Long id);
}
