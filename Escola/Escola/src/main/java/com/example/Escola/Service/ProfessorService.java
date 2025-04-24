package com.example.Escola.Service;

import com.example.Escola.DTO.ProfessorDTO;
import com.example.Escola.Entity.Professor;
import com.example.Escola.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAll(){
        return professorRepository.findAll();
    }
    public Optional<ProfessorDTO> getById(long id){
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if(professorOptional.isPresent()){
            ProfessorDTO produtoDTO = new ProfessorDTO();
            return Optional.of(produtoDTO.fromProfessor(professorOptional.get()));
        }else {
            return Optional.empty();
        }
    }
    public ProfessorDTO create(ProfessorDTO professorDTO){
        Professor professor = professorDTO.toProfessor();
        professor = professorRepository.save(professor);
        return professorDTO.fromProfessor(professor);
    }
    public Optional<ProfessorDTO> updateProfessor(Long id, ProfessorDTO professorDTO){
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()){
            Professor professor = professorOptional.get();
            professor.setNome(professorDTO.getNome());
            professor.setSobrenome(professorDTO.getSobrenome());
            professor = professorRepository.save(professor);
            return Optional.of(professorDTO.fromProfessor(professor));
        }else {
            return Optional.empty();
        }
    }
    public boolean delete(Long id){
        if(professorRepository.existsById(id)){
            professorRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
