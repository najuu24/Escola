package com.example.Escola.Controller;

import com.example.Escola.DTO.TurmaDTO;
import com.example.Escola.Service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public TurmaDTO create(@RequestBody TurmaDTO dto) {
        return turmaService.create(dto);
    }

    @GetMapping
    public List<TurmaDTO> findAll() {
        return turmaService.findAll();
    }

    @GetMapping("/{id}")
    public TurmaDTO findById(@PathVariable Long id) {
        return turmaService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public List<TurmaDTO> findByNome(@PathVariable String nome) {
        return turmaService.findByNome(nome);
    }

    @PutMapping("/{id}")
    public TurmaDTO update(@PathVariable Long id, @RequestBody TurmaDTO dto) {
        return turmaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        turmaService.delete(id);
    }

}
