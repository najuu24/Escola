package com.example.Escola.Repository;

import com.example.Escola.Entity.Aluno;
import com.example.Escola.Entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

    public interface TurmaRepository extends JpaRepository<Turma, Long> {
        List<Turma> findByNome(String nome);
}
