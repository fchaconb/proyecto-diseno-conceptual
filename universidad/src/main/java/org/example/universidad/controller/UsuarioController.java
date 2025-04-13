package org.example.universidad.controller;

import org.example.universidad.model.Usuario;
import org.example.universidad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/listar/{username}")
    public Usuario obtenerUsuarioPorUsername(@PathVariable String username) {
        return usuarioService.obtenerUsuarioPorUsuario(username);
    }

    @PutMapping("/actualizar/{username}")
    public Usuario actualizarUsuario(@PathVariable String username, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(username, usuario);
    }
}
