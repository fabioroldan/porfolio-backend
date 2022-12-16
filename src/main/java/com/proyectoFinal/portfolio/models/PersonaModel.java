package com.proyectoFinal.portfolio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class PersonaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;
    private String nacionalidad;
    private String mail;
   
    @Lob
    private String sobreMi;
    private String ocupacion;
    
    @Column( length = 2048)
    private String imgCabecera;
    
    @Column( length = 2048)
    private String imgPerfil;
    
    private String direccion;
//    redesSociales
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
