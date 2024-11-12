package br.com.leo.colegioMP.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControlle {

    @GetMapping
    public String helloTeste(){
        return "Bem vindo ao Colegio Mp ! Aqui o Amor de Deus Reina.";
    }
}
