package com.example.Escola.Controller;

import com.example.Escola.DTO.ProfessorDTO;
import com.example.Escola.Entity.Professor;
import com.example.Escola.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.Optional;

@RestController
RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAll(){
        return professorService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getById(@PathVariable Long id){
        Optional<ProfessorDTO> professorDTOOptional = professorService.getById(id);
        if (professorDTOOptional.isPresent()){
            return new ResponseEntity.ok(clienteDTOOptional.get());
        }else {
            return new ResponseEntity.notFound().build();
        }
    }
}
