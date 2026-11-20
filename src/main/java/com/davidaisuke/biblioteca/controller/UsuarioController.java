package com.davidaisuke.biblioteca.controller;

import com.davidaisuke.biblioteca.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("usuarios", usuarios);
        return "usuarios/usuarios";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Usuario item) {
        usuarios.add(item);
        return "redirect:/usuarios";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            usuarios.remove(indice);
        }
        return "redirect:/usuarios";
    }
}
