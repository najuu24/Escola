package com.example.Escola.Controller;

import com.example.Escola.DTO.AlunoDTO;
import com.example.Escola.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoDTO create(@RequestBody AlunoDTO dto) {
        return alunoService.create(dto);
    }

    @GetMapping
    public List<AlunoDTO> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public AlunoDTO findById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public AlunoDTO findByCpf(@PathVariable String cpf) {
        return alunoService.findByCpf(cpf);
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable Long id, @RequestBody AlunoDTO dto) {
        return alunoService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alunoService.delete(id);
    }

    @PostMapping("/{alunoId}/turma/{turmaId}")
    public void addToTurma(@PathVariable Long alunoId, @PathVariable Long turmaId) {
        alunoService.addToTurma(alunoId, turmaId);
    }

    @DeleteMapping("/{alunoId}/turma")
    public void removeFromTurma(@PathVariable Long alunoId) {
        alunoService.removeFromTurma(alunoId);
    }
}
