package com.proyectoFinal.portfolio.controllers;

import com.proyectoFinal.portfolio.models.ProyectoModel;
import com.proyectoFinal.portfolio.services.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {
    
    @Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/lista")
    public List<ProyectoModel>getProyecto(){
        return proyectoService.getProyecto();
    }
    
    @GetMapping("/traerporid")
    public ProyectoModel findProyecto(){
        return proyectoService.findProyecto(Long.MIN_VALUE);
    }
    
    @PostMapping("/crear")
    public ResponseEntity createProyecto(@RequestBody ProyectoModel proyec){
        proyectoService.saveProyecto(proyec);
        return ResponseEntity.ok().body(proyec);
    }
   
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarProyecto(@PathVariable("id") Long id) {
        proyectoService.deleteProyecto(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editProyecto(@PathVariable("id") Long id, @RequestBody ProyectoModel proyecto) {
        ProyectoModel proy = proyectoService.findProyecto(id);

        proy.setNombre(proyecto.getNombre());
        proy.setFecha(proyecto.getFecha());
        proy.setImagen(proyecto.getImagen());
        proy.setDescripcion(proyecto.getDescripcion());
        proy.setLink(proyecto.getLink());

        proyectoService.saveProyecto(proy);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    /*@PutMapping("/editar/{id}")
    public ProyectoModel editProyecto(@PathVariable Long id,
                                    @RequestParam("nombre") String nuevonombre,
                                    @RequestParam("fecha") int nuevofecha,
                                    @RequestParam("imagen") String nuevoimagen,
                                    @RequestParam("descripcion") String nuevodescripcion,
                                    @RequestParam("link") String nuevolink){
        ProyectoModel proyecto = proyectoService.findProyecto(id);
        
        proyecto.setNombre(nuevonombre);
        proyecto.setFecha(nuevofecha);
        proyecto.setImagen(nuevoimagen);
        proyecto.setDescripcion(nuevodescripcion);
        proyecto.setLink(nuevolink);

        proyectoService.saveProyecto(proyecto);
        return proyecto;
    }*/
    
    /*@GetMapping("/{id}")
    public ProyectoModel getProyectoById(@PathVariable("id") Long id){
        return proyectoService.getProyectoById(id);
    }
    
    @GetMapping("/query")
    public ArrayList<ProyectoModel>getProyectByNombre(@RequestParam("nombre") String nombre){
        return proyectoService.getProyectoByNombre(nombre);
    }
   
    @PutMapping("/editar/{id}")
    public ProyectoModel editProyecto (@PathVariable("id")Long id,
                                       @RequestParam ("nombre") String nuevoNombre,
                                       @RequestParam ("fecha") int nuevoFecha,
                                       @RequestParam ("descripcion") String nuevoDescripcion){
        ProyectoModel proyecto = proyectoService.findById(id);
        
        proyecto.setNombre(nuevoNombre);
        proyecto.setFecha(nuevoFecha);
        proyecto.setDescripcion(nuevoDescripcion);
        
        proyectoService.saveProyecto(proyecto);
        return proyecto;
        
    }*/
}
