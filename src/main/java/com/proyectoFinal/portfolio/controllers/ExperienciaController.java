package com.proyectoFinal.portfolio.controllers;

import com.proyectoFinal.portfolio.models.ExperienciaModel;
import com.proyectoFinal.portfolio.services.ExperienciaService;
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
@RequestMapping("/api/explaboral")//Me ahorra escribir a todos los endpoint, la url.
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/listar")
    public List<ExperienciaModel> getExperiencias() {
        return experienciaService.getExperiencias();
    }

    @GetMapping("/traerporid/{id}")
    public ResponseEntity<ExperienciaModel> findExperiencia(@PathVariable("id") Long id) {
        ExperienciaModel explab = experienciaService.getExperienciaById(Long.MIN_VALUE);
        return new ResponseEntity(explab, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity createExperiencia(@RequestBody ExperienciaModel lab) {
        experienciaService.saveExperiencia(lab);
        return ResponseEntity.ok().body(lab);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarExperiencia(@PathVariable("id") Long id) {
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") Long id, @RequestBody ExperienciaModel experiencia) {
        ExperienciaModel exp = experienciaService.findExperiencia(id);

        exp.setPosicion(experiencia.getPosicion());
        exp.setInstitucion(experiencia.getInstitucion());
        exp.setImagen(experiencia.getImagen());
        exp.setModo(experiencia.getModo());
        exp.setInicio(experiencia.getInicio());
        exp.setFin(experiencia.getFin());
        exp.setLugar(experiencia.getLugar());
        exp.setDescripcion(experiencia.getDescripcion());

        experienciaService.saveExperiencia(exp);
        return new ResponseEntity(HttpStatus.OK);
    }
}
