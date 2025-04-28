package com.example.Escola.Service;

import com.example.Escola.DTO.ProfessorDTO;
import com.example.Escola.Entity.Professor;
import com.example.Escola.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorDTO create(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setSobrenome(dto.getSobrenome());
        professor = professorRepository.save(professor);
        dto.setId(professor.getId());
        return dto;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<ProfessorDTO> findAll() {
        return professorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProfessorDTO findById(Long id) {
        return professorRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public List<ProfessorDTO> findByNome(String nome) {
        return professorRepository.findByNome(nome).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProfessorDTO update(Long id, ProfessorDTO dto) {
        Professor professor = professorRepository.findById(id).orElseThrow();
        professor.setNome(dto.getNome());
        professor.setSobrenome(dto.getSobrenome());
        professorRepository.save(professor);
        return dto;
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }

    private ProfessorDTO convertToDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setSobrenome(professor.getSobrenome());
        return dto;
    }
}
