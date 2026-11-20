package com.davidaisuke.biblioteca.controller;

import com.davidaisuke.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Livro item) {
        livros.add(item);
        return "redirect:/livros";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < livros.size()) {
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}
