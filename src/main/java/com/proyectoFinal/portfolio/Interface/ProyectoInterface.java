
package com.proyectoFinal.portfolio.Interface;

import com.proyectoFinal.portfolio.models.ProyectoModel;
import java.util.List;

public interface ProyectoInterface {
    //Traer Proyecto
    public List<ProyectoModel> getProyectos();
    
    //Guardar Proyecto
    public void saveProyecto(ProyectoModel proyec);
    
    //Eliminar Proyecto por id
    public void deleteProyecto (Long id);
    
    //Buscar Proyecto por id
    public ProyectoModel findProyecto(Long id);
}
