package com.example.Escola.Service;

import com.example.Escola.DTO.AlunoDTO;
import com.example.Escola.Entity.Aluno;
import com.example.Escola.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    // 1. buscar todos
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    // 2. buscar por id
    public Optional<AlunoDTO> getById(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            AlunoDTO alunoDTO = new AlunoDTO();
            return Optional.of(alunoDTO.fromAluno(alunoOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    // 3. buscar por cpf
    public List<Aluno> getAllByCpf(String cpf) {
        return alunoRepository.findAllByCpf(cpf);
    }


    // 4. atualizar dados
    public Optional<AlunoDTO> updateAluno(Long id, AlunoDTO alunoDTO) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setId(alunoDTO.getId());
            aluno.setNome(alunoDTO.getNome());
            aluno.setCpf(alunoDTO.getCpf());

            aluno = alunoRepository.save(aluno);

            return Optional.of(alunoDTO.fromAluno(aluno));
        } else {
            return Optional.empty();
        }
    }

    // 5. deletar
    public boolean delete(Long id) {
        if(alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
