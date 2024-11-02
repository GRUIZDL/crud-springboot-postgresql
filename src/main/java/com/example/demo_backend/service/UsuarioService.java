package com.example.demo_backend.service;

import com.example.demo_backend.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    UsuarioDto crearUsuario(UsuarioDto usuario);

    UsuarioDto obtenerUsuarioPorId(Integer idusuario);

    List<UsuarioDto> obtenerUsuarios();

    UsuarioDto actualizarUsuario(Integer idusuario, UsuarioDto usuario);

    void eliminarUsuario(Integer idusuario);

}
