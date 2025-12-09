package com.p3.trabalhoweb.controller;

import com.p3.trabalhoweb.model.Aluno;
import com.p3.trabalhoweb.service.AlunoService;
import com.p3.trabalhoweb.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cadastro")
    public String telaCadastro(Model model) {
        model.addAttribute("cursos", cursoService.listarCursos());
        return "cadastro";
    }

    @PostMapping("/adicionar")
    public String adicionar(Aluno aluno) {
        service.adicionar(aluno);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alunos", service.listar());
        return "listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        service.excluir(id);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("aluno", service.buscarPorId(id));
        model.addAttribute("cursos", cursoService.listarCursos());
        return "cadastro";
    }

    @PostMapping("/atualizar")
    public String atualizar(Aluno aluno) {
        service.atualizar(aluno);
        return "redirect:/listar";
    }
}
