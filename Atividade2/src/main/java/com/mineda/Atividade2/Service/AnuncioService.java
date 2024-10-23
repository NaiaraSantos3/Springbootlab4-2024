package com.mineda.Atividade2.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mineda.Atividade2.Model.AnuncioModel;
import com.mineda.Atividade2.Repository.AnuncioRepository;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository anuncioRepository;

    // listar todos os registros da tabela
    public List<AnuncioModel> listarAnuncios(){
        return anuncioRepository.findAll();
    }

    // outra consulta criada para o item anterior - datahora e preço
    public Optional<AnuncioModel> buscarAnuncioByDataAndPrecos(LocalDateTime dataHora, double preco){
        return anuncioRepository.findAnunciosByDataAndPreco(dataHora, preco);
    }

    // método de busca por preço e peso menores que os valores fornecidos
    public List<AnuncioModel> buscarAnuncioByPrecoAndPeso(Double preco, Double peso){
        return anuncioRepository.findByAncPrecoLessThanAndAncPesoLessThan(preco, peso);
    }

    // método para cadastrar anúncio, verificando se preço e peso são válidos
    public AnuncioModel cadastrarAnuncio(AnuncioModel anuncio){
        Double peso = anuncio.getAncPeso();
        Double preco = anuncio.getAncPreco();

        // Verifica se o preço ou peso são menores ou iguais a 0
        if(preco <= 0 || peso <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Preço e peso devem ser maiores que zero.");
        }

        // Se a data/hora não for informada, preenche com o valor atual
        if(anuncio.getAncDataHora() == null){
            anuncio.setAncDataHora(LocalDateTime.now());
        }

        return anuncioRepository.save(anuncio);
    }
}
