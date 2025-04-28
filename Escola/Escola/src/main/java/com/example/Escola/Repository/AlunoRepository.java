package com.example.Escola.Repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Escola.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpf(String cpf);
}
