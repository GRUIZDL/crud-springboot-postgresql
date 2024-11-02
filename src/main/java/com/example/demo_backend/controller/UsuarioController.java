package com.example.demo_backend.controller;

import com.example.demo_backend.dto.UsuarioDto;
import com.example.demo_backend.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        System.out.println("CONTROLLER");
        UsuarioDto usuario = usuarioService.crearUsuario(usuarioDto);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuario(@PathVariable Integer id) {
        System.out.println("CONTROLLER");
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios() {
        List<UsuarioDto> usuarioDtos = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(usuarioDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDto> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody UsuarioDto usuarioDto) {
    UsuarioDto usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioDto);
    return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Integer id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Usuario eliminado");
    }
}
