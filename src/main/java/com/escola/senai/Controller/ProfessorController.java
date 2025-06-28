package com.escola.senai.Controller;

import
        com.escola.senai.Model.Aluno;
import com.escola.senai.Model.Professor;
import com.escola.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Professor")
public class ProfessorController {

    private final AlunoService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> buscarProfessor(){
        return service.listaTodos();
    }

    @PostMapping
    public Aluno salvarNovoProfessor(@RequestBody Professor aluno){
        return service.salvar(Professor);
    }

    @GetMapping("/{id}")
    public Professor buscarAlunoId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    // CORREÇÃO 1: Mudança de @GetMapping para @DeleteMapping
    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id){
        service.excluirProfessor(id);
    }

    @PutMapping("/{id}")
    public Professor atualizaProfessor(@PathVariable Long id, @RequestBody Professor ProfessorAtualizado){
        Professor existeProfessor = service.buscarPorId(id);

        if (existeProfessor == null) {
            return null;
        }

        // Atualiza os dados do aluno existente
        existeProfessor.setNome(ProfessorAtualizado.getNome());
        existeProfessor.setEmail(ProfessorAtualizado.getEmail());
        existeProfessor.setTelefone(ProfessorAtualizado.getTelefone());

        // CORREÇÃO 2: Salva o aluno existente (com o ID correto) em vez do alunoAtualizado
        return service.salvar(existeProfessor);
    }
}
