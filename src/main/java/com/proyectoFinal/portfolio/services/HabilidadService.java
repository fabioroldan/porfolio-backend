package com.proyectoFinal.portfolio.services;

import com.proyectoFinal.portfolio.models.HabilidadModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoFinal.portfolio.repositories.HabilidadRepository;
import com.proyectoFinal.portfolio.Interface.HabilidadInterface;

@Service
public class HabilidadService implements HabilidadInterface {

    @Autowired
    HabilidadRepository habilidadRepository;

    @Override
    public List<HabilidadModel> getHabilidad() {
        List<HabilidadModel> habilidad = habilidadRepository.findAll();
        return habilidad;
    }

    @Override
    public void saveHabilidad(HabilidadModel habilidad) {
        habilidadRepository.save(habilidad);
    }

    @Override
    public void deleteHabilidad(Long id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public HabilidadModel findHabilidad(Long id) {
HabilidadModel habilidad = habilidadRepository.findById(id).orElse(null);
        return habilidad; 
    }
    
    public List<HabilidadModel> getHabilidadByTipo(String tipo) {
        return habilidadRepository.findByTipo(tipo);
    }
    
    public HabilidadModel getHabilidadById(Long id) {
        return habilidadRepository.findById(id).orElse(null);
    }
    
    /*public ArrayList<HabilidadModel> getAllHabilidads() {
        return (ArrayList<HabilidadModel>) habilidadRepository.findAll();
    }

    public HabilidadModel saveHabilidad(HabilidadModel habilidad) {
        return habilidadRepository.save(habilidad);
    }

    public boolean removeHabilidad(Long habilidadId) {
        try {
            habilidadRepository.deleteById(habilidadId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public HabilidadModel findById (Long habilidadId){
        return habilidadRepository.findById(habilidadId).orElseGet(null);
    }*/

}
