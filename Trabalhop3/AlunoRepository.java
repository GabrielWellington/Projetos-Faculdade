package com.p3.trabalhoweb.repository;

import com.p3.trabalhoweb.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
