package com.rayssa.projectWebPOO.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisciplinasController {
    @GetMapping("/disciplinas")
    public String listar(){
        return "Primeira aplicação - disciplinas";
    }
}
