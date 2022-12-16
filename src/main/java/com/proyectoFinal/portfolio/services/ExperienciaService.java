package com.proyectoFinal.portfolio.services;

import com.proyectoFinal.portfolio.models.ExperienciaModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoFinal.portfolio.Interface.ExperienciaInterface;
import com.proyectoFinal.portfolio.repositories.ExperienciaRepository;

@Service
public class ExperienciaService implements ExperienciaInterface {

    @Autowired
    ExperienciaRepository experienciaRepository;

    @Override
    public List<ExperienciaModel> getExperiencias() {
        List<ExperienciaModel> experiencias = experienciaRepository.findAll();
        return experiencias;
    }

    @Override
    public void saveExperiencia(ExperienciaModel exp) {
        experienciaRepository.save(exp);
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public ExperienciaModel findExperiencia(Long id) {
        ExperienciaModel expLab = experienciaRepository.findById(id).orElse(null);
        return expLab;
    }
    
    public ExperienciaModel getExperienciaById(Long id) {
        return experienciaRepository.findById(id).orElse(null);
    }
}
