package com.p3.trabalhoweb.service;

import com.p3.trabalhoweb.model.Aluno;
import com.p3.trabalhoweb.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public void adicionar(Aluno aluno) {
        repository.save(aluno);
    }

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public void excluir(int id) {
        repository.deleteById(id);
    }

    public Aluno buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    public void atualizar(Aluno aluno) {
        repository.save(aluno); // save() funciona para update também
    }
}
