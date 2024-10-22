package com.mineda.avaliacao.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mineda.avaliacao.Model.TrabalhoModel;
import com.mineda.avaliacao.Service.TrabalhoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    // GET: Listar todos os trabalhos
    @GetMapping
    public List<TrabalhoModel> listarTrabalhos() {
        return trabalhoService.listarTrabalhos();
    }

    // GET: Buscar trabalho por ID
    @GetMapping("/{traTitulo}")
    public Optional<TrabalhoModel> buscarTrabalhoPorTituloeNota(@PathVariable ("traTitulo") String traTitulo, @PathVariable ("notaMinima") Integer notaMinima) {
        return trabalhoService.buscarTrabalhoPorTituloAndNota(traTitulo, notaMinima);
    }

    // POST: Criar um novo trabalho
    @PostMapping
    public TrabalhoModel criarTrabalho(@RequestBody TrabalhoModel trabalho) {
        return trabalhoService.salvarTrabalho(trabalho);
    }

    // PUT: Atualizar um trabalho existente
    @PutMapping("/{traId}")
    public TrabalhoModel atualizarTrabalho(@PathVariable ("traId") int traId, @RequestBody TrabalhoModel trabalho) {
        return trabalhoService.atualizarTrabalho(traId, trabalho);
    }

    // DELETE: Deletar trabalho por ID
    @DeleteMapping("/{traId}")
    public void deletarTrabalho(@PathVariable ("tra_id") int traId) {
        trabalhoService.deletarTrabalho(traId);
    }
}
