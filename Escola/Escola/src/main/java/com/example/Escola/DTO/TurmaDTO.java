package com.example.Escola.DTO;

import com.example.Escola.Entity.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDTO implements Serializable {
    private Long id;
    private String sigla;
    private Integer numeroSala;
    private String nome;
    private ProfessorDTO professor;
    private List<AlunoDTO> alunos;

    //get set pq lombok e podre horrivel
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }
    //get set pq lombok e podre horrivel (FIM)

    public Turma toEntity() {
        Turma turma = new Turma();
        turma.setId(this.id);
        turma.setSigla(this.sigla);
        turma.setNumeroSala(this.numeroSala);
        turma.setNome(this.nome);
        if (this.professor != null) {
            turma.setProfessor(this.professor.toProfessor());
        }
        if (this.alunos != null) {
            turma.setAlunos(this.alunos.stream().map(AlunoDTO::toAluno).collect(Collectors.toList()));
        }
        return turma;
    }

    public static TurmaDTO fromEntity(Turma turma) {
        TurmaDTO dto = new TurmaDTO();
        dto.setId(turma.getId());
        dto.setSigla(turma.getSigla());
        dto.setNumeroSala(turma.getNumeroSala());
        dto.setNome(turma.getNome());
        if (turma.getProfessor() != null) {
            dto.setProfessor(ProfessorDTO.fromProfessor(turma.getProfessor()));
        }
        if (turma.getAlunos() != null) {
            dto.setAlunos(turma.getAlunos().stream().map(AlunoDTO::fromAluno).collect(Collectors.toList()));
        }
        return dto;
    }
}
