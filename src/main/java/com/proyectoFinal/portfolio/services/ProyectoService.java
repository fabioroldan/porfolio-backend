package com.proyectoFinal.portfolio.services;

import com.proyectoFinal.portfolio.Interface.ProyectoInterface;
import com.proyectoFinal.portfolio.models.ProyectoModel;
import com.proyectoFinal.portfolio.repositories.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements ProyectoInterface {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    public List<ProyectoModel> getProyectos() {
        List<ProyectoModel> proyec = proyectoRepository.findAll();
        return proyec;
    }

    @Override
    public void saveProyecto(ProyectoModel proyec) {
        proyectoRepository.save(proyec);
    }

    @Override
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public ProyectoModel findProyecto(Long id) {
        ProyectoModel proyec = proyectoRepository.findById(id).orElse(null);
        return proyec;
    }
    
    public ProyectoModel getProyectoById(Long id){
        return proyectoRepository.findById(id).orElse(null);
    }

    /*public ArrayList<ProyectoModel>getAllProyectos(){
        return (ArrayList<ProyectoModel>) proyectoRepository.findAll();
    }
    
    public ProyectoModel saveProyecto(ProyectoModel proyecto){
        return proyectoRepository.save(proyecto);
    }
    
    public ArrayList<ProyectoModel>getProyectoByNombre(String nombre){
        return proyectoRepository.findByNombre(nombre);
    }
    
    public boolean removeProyecto (Long id){
        try {
            proyectoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
            
    public ProyectoModel findById(Long proyectoId){
        return proyectoRepository.findById(proyectoId).orElseGet(null);
    }*/
}
