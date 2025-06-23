package com.rayssa.projectWebPOO.Repository;
import org.springframework.stereotype.Repository;
import com.rayssa.projectWebPOO.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}