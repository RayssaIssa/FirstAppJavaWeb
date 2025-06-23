package com.rayssa.projectWebPOO;

import com.rayssa.projectWebPOO.Model.Aluno;
import com.rayssa.projectWebPOO.Model.Disciplina;
import com.rayssa.projectWebPOO.Repository.AlunoRepository;
import com.rayssa.projectWebPOO.Repository.DisciplinaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;

@SpringBootApplication
public class ProjectWebPooApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebPooApplication.class, args);
	}

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public void run(String... args) throws Exception {
		Disciplina d1 = new Disciplina(null,"Programação Orientada a Objetos", 64);
		Disciplina d2 = new Disciplina(null,"Pesquisa Operacional", 64);
		Disciplina d3 = new Disciplina(null,"IA", 64);

		Aluno a1 = new Aluno(null, "Maria Alves", "mariaalves@gmail.com", "123", "CDC");
		Aluno a2 = new Aluno(null, "Pedro Moraes", "pedromoraes@gmail.com", "546", "CDC");
		Aluno a3 = new Aluno(null, "Walter Silva", "waltersilva@gmail.com", "789", "CDC");
		Aluno a4 = new Aluno(null, "Marcos Andrade", "marcosandrade@gmail.com", "1012", "CDC");
		Aluno a5 = new Aluno(null, "Gustavo Oliveira", "gustavooliveira@gmail.com", "1234", "CDC");

		d1.getAlunos().addAll(Arrays.asList(a1,a2,a3));
		d2.getAlunos().addAll(Arrays.asList(a2,a4));
		d3.getAlunos().addAll(Arrays.asList(a1,a3,a5));

		alunoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5));
		disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));
	}

}