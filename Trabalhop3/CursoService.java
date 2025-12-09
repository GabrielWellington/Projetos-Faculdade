package com.p3.trabalhoweb.service;

import com.p3.trabalhoweb.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    public List<Curso> listarCursos() {
        return List.of(
                new Curso("Análise e Desenvolvimento de Sistemas"),
                new Curso("Análise e Desenvolvimento de Sistemas (AMS)"),
                new Curso("Gestão da Produção Industrial"),
                new Curso("Gestão da Qualidade"),
                new Curso("Gestão de Negócios e Inovação"),
                new Curso("Gestão Empresarial (EAD)"),
                new Curso("Logística"),
                new Curso("Sistemas para Internet")
        );
    }
}
