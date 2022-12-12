package com.proyectoFinal.portfolio.Interface;

import com.proyectoFinal.portfolio.models.HabilidadModel;
import java.util.List;

public interface HabilidadInterface {
    //Traer Habilidad
    public List<HabilidadModel> getHabilidad();
    
    //Guardar Habilidad
    public void saveHabilidad(HabilidadModel habilidad);
    
    //Eliminar Habilidad por id
    public void deleteHabilidad (Long id);
    
    //Buscar Habilidad por id
    public HabilidadModel findHabilidad(Long id);
}
