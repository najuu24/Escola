package com.example.Escola.Service;

import com.example.Escola.DTO.AlunoDTO;
import com.example.Escola.DTO.ProfessorDTO;
import com.example.Escola.Entity.Aluno;
import com.example.Escola.Entity.Professor;
import com.example.Escola.Entity.Turma;
import com.example.Escola.Repository.AlunoRepository;
import com.example.Escola.Repository.ProfessorRepository;
import com.example.Escola.Repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public AlunoDTO create(AlunoDTO dto) {
        Aluno aluno = alunoRepository.save(dto.toAluno());
        return AlunoDTO.fromAluno(aluno);
    }

    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll().stream()
                .map(AlunoDTO::fromAluno)
                .collect(Collectors.toList());
    }

    public AlunoDTO findById(Long id) {
        return alunoRepository.findById(id)
                .map(AlunoDTO::fromAluno)
                .orElse(null);
    }

    public AlunoDTO findByCpf(String cpf) {
        return alunoRepository.findByCpf(cpf)
                .map(AlunoDTO::fromAluno)
                .orElse(null);
    }

    public AlunoDTO update(Long id, AlunoDTO dto) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        alunoRepository.save(aluno);
        return AlunoDTO.fromAluno(aluno);
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    public void addToTurma(Long alunoId, Long turmaId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Turma turma = turmaRepository.findById(turmaId).orElseThrow();
        aluno.setTurma(turma);
        alunoRepository.save(aluno);
    }

    public void removeFromTurma(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        aluno.setTurma(null);
        alunoRepository.save(aluno);
    }
}
