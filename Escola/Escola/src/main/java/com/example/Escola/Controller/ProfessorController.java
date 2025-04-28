package com.example.Escola.Controller;

import com.example.Escola.DTO.ProfessorDTO;
import com.example.Escola.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ProfessorDTO create(@RequestBody ProfessorDTO dto) {
        return professorService.create(dto);
    }

    @GetMapping
    public List<ProfessorDTO> findAll() {
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public ProfessorDTO findById(@PathVariable Long id) {
        return professorService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public List<ProfessorDTO> findByNome(@PathVariable String nome) {
        return professorService.findByNome(nome);
    }

    @PutMapping("/{id}")
    public ProfessorDTO update(@PathVariable Long id, @RequestBody ProfessorDTO dto) {
        return professorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        professorService.delete(id);
    }
}
