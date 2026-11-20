package com.davidaisuke.biblioteca.controller;

import com.davidaisuke.biblioteca.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategorController {
    private final List<Categoria> categorias = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("categorias", categorias);
        return "categorias/categorias";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Categoria item) {
        categorias.add(item);
        return "redirect:/categorias";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
