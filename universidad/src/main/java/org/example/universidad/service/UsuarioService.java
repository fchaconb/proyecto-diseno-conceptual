package org.example.universidad.service;

import org.example.universidad.model.Usuario;
import org.example.universidad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorUsuario(String usuario) {
        return usuarioRepository.findById(usuario).orElse(null);
    }

    public void eliminarUsuario(String username) {
        usuarioRepository.deleteById(username);
    }

    public Usuario actualizarUsuario(String username, Usuario usuario) {
        Usuario usuarioExistente = obtenerUsuarioPorUsuario(username);
        if (usuarioExistente != null) {
            usuarioExistente.setContrasena(usuario.getContrasena());
            usuarioExistente.setRol(usuario.getRol());
            return usuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

}
