package com.mineda.Atividade2.Controller;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mineda.Atividade2.Model.AnuncioModel;
import com.mineda.Atividade2.Service.AnuncioService;

@RestController
@RequestMapping("/anuncio")
public class AnuncioController {
    
    @Autowired
    private AnuncioService anuncioService;

    @PostMapping
    public AnuncioModel cadastrAnuncio(@RequestBody AnuncioModel anuncio){
        return anuncioService.cadastrarAnuncio(anuncio);
    }

    @GetMapping
    public List<AnuncioModel> listarAnuncios(){
        return anuncioService.listarAnuncios();
    }

    @GetMapping ({"/dataHora"})
    public Optional<AnuncioModel>buscarAnuncioByDataAndPrecos(@PathVariable ("dataHora") LocalDateTime dataHora, 
    @PathVariable ("preco") double preco){
        return anuncioService.buscarAnuncioByDataAndPrecos(dataHora, preco);
    }

    
}





// crie um controller que atenda na URL"\anuncio" e contenha 3 rotas: uma para cadastro,
//outra para listar todos os registros e uma última para a consulta descrita no item 2




    