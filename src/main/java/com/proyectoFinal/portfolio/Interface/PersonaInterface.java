
package com.proyectoFinal.portfolio.Interface;

import com.proyectoFinal.portfolio.models.PersonaModel;
import java.util.List;

public interface PersonaInterface {
    //Traer personas
    public List<PersonaModel> getPersonas();
    
    //Guardar persona
    public void savePersona(PersonaModel perso);
    
    //Eliminar persona por id
    public void deletePersona (Long id);
    
    //Buscar persona por id
    public PersonaModel findPersona(Long id);
    
}
