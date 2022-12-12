package com.proyectoFinal.portfolio.controllers;

import com.proyectoFinal.portfolio.models.PersonaModel;
import com.proyectoFinal.portfolio.services.PersonaService;
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
@RequestMapping("/api/persona")//Me ahorra escribir a todos los endpoint, la url.
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public List<PersonaModel> getPersona() {
        return personaService.getPersona();
    }
    
     @GetMapping("/mensaje")
    public String getMensaje() {
        return "Esto es un mensaje desde la api de persona!";
    }

    @GetMapping("/traer")
    public PersonaModel findPersona() {
        return personaService.findPersona((long) 3);
    }

    @GetMapping("/traerporid/{id}")
    public ResponseEntity<PersonaModel> findPersonById(@PathVariable("id") Long id) {
        PersonaModel perso = personaService.findById(id);
        return new ResponseEntity(perso, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public String createPersona(@RequestBody PersonaModel persona) {
        personaService.savePersona(persona);
        return "La persona se creó correctamente.";
    }

    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return "La persona se eliminó correctamente.";
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity <?> editPersona(@PathVariable("id") Long id, @RequestBody PersonaModel persona) {
        PersonaModel perso = personaService.findPersona(id);

        perso.setNombre(persona.getNombre());
        perso.setApellido(persona.getApellido());
        perso.setTitulo(persona.getTitulo());
        perso.setDescripcion(persona.getDescripcion());
        perso.setImage_perfil(persona.getImage_perfil());
        perso.setBanner(persona.getBanner());

        personaService.savePersona(perso);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*@PutMapping("/editar/{id}")
    public PersonaModel editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam("image_perfil") String nuevoImagePerfil,
            @RequestParam("banner") String nuevoBanner) {
        PersonaModel persona = personaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setTitulo(nuevoTitulo);
        persona.setDescripcion(nuevoDescripcion);
        persona.setImage_perfil(nuevoImagePerfil);
        persona.setBanner(nuevoBanner);

        personaService.savePersona(persona);
        return persona;
    }*/
    

    /*@GetMapping("/all")
    public ArrayList<PersonaModel>getAllPersons(){
        return personaService.getAllPersons();
    }
    //....................................................
    @GetMapping("/traerid")
    public PersonaModel findPersona(){
        return personaService.findById((long)3);
    }
    //....................................................

    @PostMapping("/crear")
    public PersonaModel savePerson(@RequestBody PersonaModel persona){
        return personaService.savePerson(persona);
        //En Postman, para crear una Persona, no tengo q especificar el "id" xq una "persona" nueva
        //no tiene "id", sino q se le asigna automáticamente, además me va a modificar una persina existente.
        //Tengo q definir los demás atributos, en este caso: nombre, apellido, url_img
    }
    
    @GetMapping("/query")
    //ATENCIÓN...acá se tuvo q crear método en Repository para luego llamarlo en el Service y luego poder llamarlo acá.
    public ArrayList<PersonaModel>getPersonaByApellido(@RequestParam ("apellido")String apellido){
        return personaService.getPersonaByApellido(apellido);
    }
    
    @DeleteMapping("/borrar/{id}")
    public String removePerson(@PathVariable("id") Long id){
        if (personaService.removePerson(id)){
            return "Se eliminó a la persona con id "+id+" correctamente.";
        }else{
            return "La persona con id "+id+" no pudo ser eliminada.";
        }
    }
    
    
    }*/
}
