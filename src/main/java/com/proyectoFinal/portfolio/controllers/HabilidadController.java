package com.proyectoFinal.portfolio.controllers;

import com.proyectoFinal.portfolio.models.HabilidadModel;
import com.proyectoFinal.portfolio.services.HabilidadService;
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
@RequestMapping("/api/habilidad")
public class HabilidadController {

    @Autowired
    HabilidadService habilidadService;

    @GetMapping("/lista")
    public List<HabilidadModel> getAllHabilidads() {
        return habilidadService.getHabilidad();
    }
    
     @GetMapping("/traerporid/{id}")
    public ResponseEntity<HabilidadModel> findHabilidad(@PathVariable("id") Long id) {
        HabilidadModel habilidad = habilidadService.getHabilidadById(id);
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @GetMapping("/query")
    //ATENCIÓN...acá se tuvo q crear método en Repository para luego llamarlo en el Service y luego poder llamarlo acá.
    public List<HabilidadModel> getHabilidadByTipo(@RequestParam("tipo") String tipo) {
        return habilidadService.getHabilidadByTipo(tipo);
    }
    
    @PostMapping("/crear")
    public ResponseEntity createHabilidad(@RequestBody HabilidadModel habilidad){
        habilidadService.saveHabilidad(habilidad);
        return ResponseEntity.ok().body(habilidad);
    }
   
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarHabilidad(@PathVariable("id") Long id) {
        habilidadService.deleteHabilidad(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editHabilidad(@PathVariable("id") Long id, @RequestBody HabilidadModel habilidad) {
        HabilidadModel sk = habilidadService.findHabilidad(id);

        sk.setTipo(habilidad.getTipo());
        sk.setNombre(habilidad.getNombre());
        sk.setPorcentaje(habilidad.getPorcentaje());

        habilidadService.saveHabilidad(sk);
        return new ResponseEntity(HttpStatus.OK);
    }
    /*@PutMapping("/editar/{id}")
    public HabilidadModel editHabilidad(@PathVariable Long id,
                                    @RequestParam("tipo") String nuevotipo,
                                    @RequestParam("nombre") String nuevonombre,
                                    @RequestParam("porcentaje") int nuevoporcentaje){
        HabilidadModel habilidad = habilidadService.findHabilidad(id);
        
        habilidad.setTipo(nuevotipo);
        habilidad.setNombre(nuevonombre);
        habilidad.setPorcentaje(nuevoporcentaje);

        habilidadService.saveHabilidad(habilidad);
        return habilidad;
    }*/
    
    /*@GetMapping("/{id}")
    public HabilidadModel getHabilidadById(@PathVariable("id") Long id) {
        return habilidadService.getHabilidadById(id);
    }*/
}
