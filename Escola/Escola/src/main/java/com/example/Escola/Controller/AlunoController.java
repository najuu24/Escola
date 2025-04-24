package com.example.Escola.Controller;

import com.example.Escola.DTO.AlunoDTO;
import com.example.Escola.Entity.Aluno;
import com.example.Escola.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    // 1. buscar todos
    @GetMapping
    public List<Aluno> getAll(@RequestParam(required = false) String cpf) {
        if(cpf != null && !cpf.isEmpty()) {
            return alunoService.getAllByCpf(cpf);
        }
        return alunoService.getAll();
    }

    // 2. buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getById(@PathVariable Long id) {
        Optional<AlunoDTO> alunoDTOOptional = alunoService.getById(id);
        if (alunoDTOOptional.isPresent()) {
            return ResponseEntity.ok(alunoDTOOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. cadastrar alunos
    @PostMapping
    public ResponseEntity<AlunoDTO> create(@RequestBody AlunoDTO alunoDTO) {
        AlunoDTO alunoDTOSave = alunoService.createAluno(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTOSave);
    }

    // 5. atualizar dados
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        Optional<AlunoDTO> alunoDTOOptional = alunoService.updateAluno(id, alunoDTO);
        if (alunoDTOOptional.isPresent()) {
            return ResponseEntity.ok(alunoDTOOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (alunoService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
