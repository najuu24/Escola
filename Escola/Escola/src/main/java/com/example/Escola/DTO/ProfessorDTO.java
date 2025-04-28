package com.example.Escola.DTO;

import com.example.Escola.Entity.Professor;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO implements Serializable {
    private Long id;
    private String nome;
    private String sobrenome;

    //get set pq lombok e podre horrivel
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    //get set pq lombok e podre horrivel (FIM)

    public Professor toProfessor() {
        Professor professor = new Professor();
        professor.setId(this.id);
        professor.setNome(this.nome);
        professor.setSobrenome(this.sobrenome);
        return professor;
    }

    public static ProfessorDTO fromProfessor(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setSobrenome(professor.getSobrenome());
        return dto;
    }
}
