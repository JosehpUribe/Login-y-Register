package com.Josehp.servicio;

import com.Josehp.Entidad.Usuario;
import com.Josehp.Repositorio.UsuarioRepositorio;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    public void registrarUsuario(@Valid Usuario usuario) {
        String contraseñaEncriptada = BCrypt.hashpw(usuario.getContraseña(), BCrypt.gensalt());
        usuario.setContraseña(contraseñaEncriptada);
        usuarioRepository.save(usuario);
    }

    public boolean validarLogin(String nombreUsuario, String contraseña) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario).orElse(null);
        return usuario != null && BCrypt.checkpw(contraseña, usuario.getContraseña());
    }
}