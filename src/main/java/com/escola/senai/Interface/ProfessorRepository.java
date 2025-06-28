package com.escola.senai.Interface;

import com.escola.senai.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Aluno, Long> {
}
