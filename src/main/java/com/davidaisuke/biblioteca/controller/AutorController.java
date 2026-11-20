package com.davidaisuke.biblioteca.controller;

import com.davidaisuke.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private final List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autores", autores);
        return "autores/autores";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Autor item) {
        autores.add(item);
        return "redirect:/autores";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}
