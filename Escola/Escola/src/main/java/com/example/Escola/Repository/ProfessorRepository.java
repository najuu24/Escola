package com.example.Escola.Repository;

import com.example.Escola.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface ProfessorRepository extends JpaRepository<Professor, Long> {
        List<Professor> findByNome(String nome);
}
