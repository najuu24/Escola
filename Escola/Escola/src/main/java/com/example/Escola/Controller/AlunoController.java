package com.example.Escola.Controller;

import com.example.Escola.Entity.Aluno;
import com.example.Escola.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    // 1. buscar todos
    @GetMapping
    public List<Aluno> getAll(@RequestParam(required = false) String cpf) {
        if(cpf != null && )
    }
}
