package com.example.Escola.Service;

import com.example.Escola.DTO.AlunoDTO;
import com.example.Escola.DTO.ProfessorDTO;
import com.example.Escola.DTO.TurmaDTO;
import com.example.Escola.Entity.Professor;
import com.example.Escola.Entity.Turma;
import com.example.Escola.Repository.ProfessorRepository;
import com.example.Escola.Repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoService alunoService;

    public TurmaDTO create(TurmaDTO dto) {
        Turma turma = new Turma();
        turma.setSigla(dto.getSigla());
        turma.setNumeroSala(dto.getNumeroSala());
        turma.setNome(dto.getNome());
        Professor professor = professorRepository.findById(dto.getProfessor().getId()).orElseThrow();
        turma.setProfessor(professor);
        turma = turmaRepository.save(turma);
        dto.setId(turma.getId());
        return dto;
    }

    public List<TurmaDTO> findAll() {
        return turmaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TurmaDTO findById(Long id) {
        return turmaRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public List<TurmaDTO> findByNome(String nome) {
        return turmaRepository.findByNome(nome).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TurmaDTO update(Long id, TurmaDTO dto) {
        Turma turma = turmaRepository.findById(id).orElseThrow();
        turma.setSigla(dto.getSigla());
        turma.setNumeroSala(dto.getNumeroSala());
        turma.setNome(dto.getNome());
        Professor professor = professorRepository.findById(dto.getProfessor().getId()).orElseThrow();
        turma.setProfessor(professor);
        turmaRepository.save(turma);
        return dto;
    }

    public void delete(Long id) {
        Turma turma = turmaRepository.findById(id).orElseThrow();
        turma.getAlunos().forEach(aluno -> alunoService.removeFromTurma(aluno.getId()));
        turmaRepository.deleteById(id);
    }

    private TurmaDTO convertToDTO(Turma turma) {
        TurmaDTO dto = new TurmaDTO();
        dto.setId(turma.getId());
        dto.setSigla(turma.getSigla());
        dto.setNumeroSala(turma.getNumeroSala());
        dto.setNome(turma.getNome());

        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(turma.getProfessor().getId());
        professorDTO.setNome(turma.getProfessor().getNome());
        professorDTO.setSobrenome(turma.getProfessor().getSobrenome());
        dto.setProfessor(professorDTO);

        List<AlunoDTO> alunoDTOs = turma.getAlunos().stream().map(aluno -> {
            AlunoDTO alunoDTO = new AlunoDTO();
            alunoDTO.setId(aluno.getId());
            alunoDTO.setNome(aluno.getNome());
            alunoDTO.setCpf(aluno.getCpf());
            return alunoDTO;
        }).collect(Collectors.toList());
        dto.setAlunos(alunoDTOs);

        return dto;
    }
}
