package com.mineda.avaliacao.Service;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import com.mineda.avaliacao.Model.TrabalhoModel;
import com.mineda.avaliacao.Repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public TrabalhoModel salvarTrabalho(TrabalhoModel trabalho) {
        if (trabalho.getTraTitulo() == null || trabalho.getTraTitulo().isBlank() ||
        trabalho.getTraGrupo() == null || trabalho.getTraGrupo().isBlank() ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos");
        }
        if (trabalho.getTraDataHoraEntrega() == null ){
            trabalho.setTraDataHoraEntrega(LocalDateTime.now());
        }


        return trabalhoRepository.save(trabalho); 
    }

    public List<TrabalhoModel> listarTrabalhos() {
        return trabalhoRepository.findAll();
    }


    public Optional<TrabalhoModel> buscarTrabalhoPorTituloAndNota(String traTitulo, Integer notaMinima) {
        return trabalhoRepository.findTrabalhosByTituloAndNotaMinima(traTitulo, notaMinima); 
    }

    // talvez nn precise
    public TrabalhoModel atualizarTrabalho(int traId, TrabalhoModel trabalhoAtualizado) {
        Optional<TrabalhoModel> trabalhoExistente = trabalhoRepository.findById(traId);

        if (trabalhoExistente.isPresent()) {
            TrabalhoModel trabalho = trabalhoExistente.get();
            trabalho.setTraTitulo(trabalhoAtualizado.getTraTitulo()); 
            trabalho.setTraDescricao(trabalhoAtualizado.getTraDescricao()); 
            return trabalhoRepository.save(trabalho); 
        } else {
            throw new RuntimeException("Trabalho não encontrado"); 
        }
    }

    //talvez nn precise
    public void deletarTrabalho(int traId) { 
        trabalhoRepository.deleteById(traId); 
    }
}


