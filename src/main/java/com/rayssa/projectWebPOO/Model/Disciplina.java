package com.rayssa.projectWebPOO.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="DISCIPLINAS")
public class Disciplina {
	@Id // fala que é uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disciplina_id")
	private Integer id;
	
	@Column(name = "nome_disciplina", nullable = false)
	private String nome;
	
	private Integer carga_horaria;

	//Junção de tabelas entre disciplina e alunos
	@ManyToMany
	@JoinTable(name="DISCIPLINAS_ALUNOS",
			joinColumns = @JoinColumn(name = "disciplina_id"),
			inverseJoinColumns = @JoinColumn(name = "aluno_id"))

	private List<Aluno> alunos = new ArrayList<>();
	
    public Disciplina() {
    	
    }
    
	public Disciplina(Integer id, String nome, Integer carga_horaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.carga_horaria = carga_horaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}
}
