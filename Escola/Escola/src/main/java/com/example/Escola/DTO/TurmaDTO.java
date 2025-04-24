package com.example.Escola.DTO;

import com.example.Escola.Entity.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDTO implements Serializable {
    private Long id;
    private String sigla;
    private int numeroSala;
    private String nome;

    public Turma toTurma() {
        return new Turma(
                this.id,
                this.sigla,
                this.numeroSala,
                this.nome
        );
    }

    public TurmaDTO fromTurma(Turma turma) {
        return new TurmaDTO(
                turma.getId(),
                turma.getSigla(),
                turma.getNumeroSala(),
                turma.getNome()
        );
    }
}
