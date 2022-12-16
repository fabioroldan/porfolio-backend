package com.proyectoFinal.portfolio.services;

import com.proyectoFinal.portfolio.models.EstudioModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoFinal.portfolio.repositories.EstudioRepository;
import com.proyectoFinal.portfolio.Interface.EstudioInterface;

@Service
public class EstudioService implements EstudioInterface{     
    @Autowired
    EstudioRepository estudioRepository;
   
    @Override
    public List<EstudioModel> getEstudios() {
        List<EstudioModel> estudios = estudioRepository.findAll();
        return estudios;
    }
    
    @Override
    public void saveEstudio(EstudioModel est) {
        estudioRepository.save(est);
    }
    
    @Override
    public void deleteEstudio(Long id) {
        estudioRepository.deleteById(id);
    }
    
    @Override
    public EstudioModel findEstudio(Long id) {
       EstudioModel estudio = estudioRepository.findById(id).orElse(null);
        return estudio;
    }
    
    public EstudioModel getEstudioById(Long id){
        return estudioRepository.findById(id).orElse(null);
    }
}
