package com.rayssa.projectWebPOO.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALUNOS")
public class Aluno extends Pessoa{
    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String curso;

    @ManyToMany(mappedBy = "alunos")
    @JsonIgnore
    private List<Disciplina> disciplinas = new ArrayList<>();

    Aluno(){}

    Aluno(Integer id, String nome, String email, String matricula, String curso){
        super(id, nome, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    //Sets e Gets

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
