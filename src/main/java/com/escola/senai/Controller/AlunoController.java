package com.escola.senai.Controller;

import com.escola.senai.Model.Aluno;
import com.escola.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/alunos")

public class AlunoController {
    private final AlunoService Service;


    public AlunoController(AlunoService service) {
        Service = service;
    }
    @GetMapping
    public List<Aluno> buscarAluno(){
        return Service.listaTodos();
    }

    @PostMapping
    public Aluno salvarNovoAluno(@RequestBody Aluno aluno){
        return Service.salvar(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscarAlunoId(@PathVariable Long id){
        return Service.buscarPorId(id);
    }

    @GetMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
         Service.excluirAluno(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizaAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        Aluno existeAluno = Service.buscarPorId(id);
            if (existeAluno == null) return null;

            existeAluno.setNome(alunoAtualizado.getNome());
            existeAluno.setEmail(alunoAtualizado.getEmail());
            existeAluno.setTelefone(alunoAtualizado.getTelefone());

        return Service.salvar(alunoAtualizado);

    }

}
