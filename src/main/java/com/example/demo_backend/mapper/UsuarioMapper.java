package com.example.demo_backend.mapper;

import com.example.demo_backend.dto.UsuarioDto;
import com.example.demo_backend.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDto mapToUsuarioDto(Usuario usuario) {
        System.out.println("MAPPER TO USUARIO DTO");
        return new UsuarioDto(
                usuario.getIdusuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEdad(),
                usuario.getSexo()
        );
    }

    public static Usuario mapToUsuario(UsuarioDto usuarioDto) {
        System.out.println("MAPPER TO USUARIO ENTITY");
        return new Usuario(
                usuarioDto.getIdUsuario(),
                usuarioDto.getNombre(),
                usuarioDto.getApellido(),
                usuarioDto.getEdad(),
                usuarioDto.getSexo()
        );
    }
}
