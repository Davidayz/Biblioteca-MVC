package com.davidaisuke.biblioteca.controller;

import com.davidaisuke.biblioteca.model.Emprestimos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimosController {
    private final List<Emprestimos> emprestimos = new ArrayList<>();

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/emprestimos";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Emprestimos item) {
        emprestimos.add(item);
        return "redirect:/emprestimos";
    }

    @PostMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
