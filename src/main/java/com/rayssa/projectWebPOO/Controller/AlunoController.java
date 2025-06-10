package com.rayssa.projectWebPOO.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {
    @GetMapping("/alunos")
    public String listar(){
        return "Primeira aplicação";
    }
}
