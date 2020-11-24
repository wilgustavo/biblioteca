package com.example.fluxgc.web;

import com.example.fluxgc.domain.Autor;
import lombok.Data;

@Data
public class AutorDto {

    private String id;
    private String nombre;


    public Autor toDomain() {
        return new Autor(id, nombre);
    }

}
