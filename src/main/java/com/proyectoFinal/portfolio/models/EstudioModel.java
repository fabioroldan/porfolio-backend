package com.proyectoFinal.portfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "educacion")
@Getter
@Setter
public class EstudioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institucion;
    private String titulo;
    private String imagen;
    private String promedio;
    private String inicio;
    private String fin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
