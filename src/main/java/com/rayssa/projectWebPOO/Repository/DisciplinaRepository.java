package com.rayssa.projectWebPOO.Repository;
import org.springframework.stereotype.Repository;
import com.rayssa.projectWebPOO.Model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}