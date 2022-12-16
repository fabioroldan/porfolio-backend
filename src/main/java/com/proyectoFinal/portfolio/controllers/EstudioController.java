package com.proyectoFinal.portfolio.controllers;

import com.proyectoFinal.portfolio.models.EstudioModel;
import com.proyectoFinal.portfolio.services.EstudioService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudio")
public class EstudioController {

    @Autowired
    EstudioService estudioService;

    @GetMapping("/listar")
    public List<EstudioModel> getEstudios() {
        return estudioService.getEstudios();
    }

    @GetMapping("/traerporid/{id}")
    public ResponseEntity<EstudioModel> findEstudio(@PathVariable("id") Long id) {
        EstudioModel est = estudioService.getEstudioById(Long.MIN_VALUE);
        return new ResponseEntity(est, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")//PARA Q SÓLO EL ROL "ADMIN" PUEDA EJECUTAR
    @PostMapping("/crear")
    public ResponseEntity createEstudio(@RequestBody EstudioModel est) {
        estudioService.saveEstudio(est);
        return ResponseEntity.ok().body(est);
    }
   
    //@PreAuthorize("hasRole('ADMIN')")//PARA Q SÓLO EL ROL "ADMIN" PUEDA EJECUTAR
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editEstudio(@PathVariable("id") Long id, @RequestBody EstudioModel estudio) {
        EstudioModel est = estudioService.findEstudio(id);

        est.setInstitucion(estudio.getInstitucion());
        est.setTitulo(estudio.getTitulo());
        est.setImagen(estudio.getImagen());
        est.setPromedio(estudio.getPromedio());
        est.setInicio(estudio.getInicio());
        est.setFin(estudio.getFin());

        estudioService.saveEstudio(est);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")//PARA Q SÓLO EL ROL "ADMIN" PUEDA EJECUTAR
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarEstudio(@PathVariable("id") Long id) {
        estudioService.deleteEstudio(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
