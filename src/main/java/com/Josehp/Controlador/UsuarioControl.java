package com.Josehp.Controlador;

import com.Josehp.Entidad.Usuario;
import com.Josehp.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UsuarioControl {

    @Autowired
    private UsuarioServicio usuarioService;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index"; // Se espera que exista index.jsp
    }

    @PostMapping("/procesa/registro")
    public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "index"; // Vuelve al formulario
        }
        usuarioService.registrarUsuario(usuario);
        return "redirect:/inicio"; // Redirige a inicio
    }

    @PostMapping("/procesa/login")
    public String procesarLogin(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        if (result.hasErrors() || !usuarioService.validarLogin(usuario.getNombreUsuario(), usuario.getContraseña())) {
            // Manejar error de login
            return "index"; // Vuelve al formulario
        }
        return "redirect:/inicio"; // Redirige a inicio
    }

    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio"; // Se espera que exista inicio.jsp
    }
}