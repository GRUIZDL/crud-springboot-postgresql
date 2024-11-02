package com.example.demo_backend.service.impl;

import com.example.demo_backend.dto.UsuarioDto;
import com.example.demo_backend.entity.Usuario;
import com.example.demo_backend.exception.ResourceNotFoundException;
import com.example.demo_backend.mapper.UsuarioMapper;
import com.example.demo_backend.repository.UsuarioRepository;
import com.example.demo_backend.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {
        System.out.println("SERVICE");
        Usuario usuario = UsuarioMapper.mapToUsuario(usuarioDto);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.mapToUsuarioDto(savedUsuario);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(Integer idusuario) {
        Usuario usuario = usuarioRepository.findById(idusuario).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + idusuario));
        return UsuarioMapper.mapToUsuarioDto(usuario);
    }

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map((usuario) -> UsuarioMapper.mapToUsuarioDto(usuario)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto actualizarUsuario(Integer idusuario, UsuarioDto usuario) {
        Usuario usuarioEncontrado = usuarioRepository.findById(idusuario).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + idusuario));
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setApellido(usuario.getApellido());
        usuarioEncontrado.setEdad(usuario.getEdad());
        usuarioEncontrado.setSexo(usuario.getSexo());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioEncontrado);
        return UsuarioMapper.mapToUsuarioDto(usuarioActualizado);
    }

    @Override
    public void eliminarUsuario(Integer idusuario) {
        Usuario usuario = usuarioRepository.findById(idusuario).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + idusuario));
        usuarioRepository.deleteById(idusuario);
    }
}
