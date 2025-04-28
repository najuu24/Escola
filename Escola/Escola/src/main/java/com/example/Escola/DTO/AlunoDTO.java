package com.example.Escola.DTO;

import com.example.Escola.Entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO implements Serializable {
    private Long id;
    private String nome;
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    //get set pq lombok e podre horrivel (FIM)

    public Aluno toAluno() {
        Aluno aluno = new Aluno();
        aluno.setId(this.id);
        aluno.setNome(this.nome);
        aluno.setCpf(this.cpf);
        return aluno;
    }

    public static AlunoDTO fromAluno(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setCpf(aluno.getCpf());
        return dto;
    }

}
