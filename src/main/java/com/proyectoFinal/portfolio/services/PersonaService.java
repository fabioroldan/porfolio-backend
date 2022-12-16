package com.proyectoFinal.portfolio.services;

import com.proyectoFinal.portfolio.Interface.PersonaInterface;
import com.proyectoFinal.portfolio.models.PersonaModel;
import com.proyectoFinal.portfolio.repositories.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements PersonaInterface {

    @Autowired
    PersonaRepository personaRepository;
    
    @Override
    public List<PersonaModel> getPersonas() {
        List<PersonaModel> personas = personaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(PersonaModel pers) {
        personaRepository.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaModel findPersona(Long id) {
        PersonaModel persona = personaRepository.findById(id).orElse(null);
        return persona;
    }
    
    public PersonaModel findById(Long id) {
        return personaRepository.findById(id).get();
    }

    /*public ArrayList<PersonaModel> getAllPersons() {
        return (ArrayList<PersonaModel>) personaRepository.findAll();
    }

    public PersonaModel savePerson(PersonaModel persona) {
        return personaRepository.save(persona);
    }

    public Optional<PersonaModel> getPersonById(Long id) {
        return personaRepository.findById(id);
    }

    public ArrayList<PersonaModel> getPersonaByApellido(String apellido) {
        //findByApellido: método creado en el Repository.
        return personaRepository.findByApellido(apellido);
    }

    public boolean removePerson(Long id) {
        try {
            personaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    */

    
}
