package br.com.springbootcrud.springbootrestapisample.controllers;
import br.com.springbootcrud.springbootrestapisample.model.Usuario;
import br.com.springbootcrud.springbootrestapisample.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingTRext(@PathVariable String name){
        return "Curso Spring Boot API: " + name + "!";
    }

    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String test(@PathVariable String name) {


        Usuario usuario = new Usuario();
        usuario.setName(name);
        usuario.setAge(24);
        usuarioRepository.save(usuario);

        return "Curso Spring Boot API: " + name + "!";
    }

    }
