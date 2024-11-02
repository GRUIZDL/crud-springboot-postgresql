package com.example.demo_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String edad;
    private String sexo;
}
