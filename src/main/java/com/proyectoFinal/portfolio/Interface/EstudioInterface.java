package com.proyectoFinal.portfolio.Interface;

import com.proyectoFinal.portfolio.models.EstudioModel;
import java.util.List;

public interface EstudioInterface {
     //Traer estudio
    public List<EstudioModel> getEstudios();
    
    //Guardar estudio
    public void saveEstudio(EstudioModel est);
    
    //Eliminar estudio por id
    public void deleteEstudio (Long id);
    
    //Buscar estudio por id
    public EstudioModel findEstudio(Long id);
}
