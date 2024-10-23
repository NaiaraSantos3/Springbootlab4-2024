package com.mineda.Atividade2.Repository;

import com.mineda.Atividade2.Model.AnuncioModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Long> {

    // Consulta customizada para buscar anúncios por data e preço
    @Query("SELECT t FROM AnuncioModel t WHERE t.ancDataHora >= :dataHora AND t.ancPreco <= :preco")
    Optional<AnuncioModel> findAnunciosByDataAndPreco(LocalDateTime dataHora, Double preco);

    // Consulta derivada para buscar anúncios com preço e peso menores que os fornecidos
    List<AnuncioModel> findByAncPrecoLessThanAndAncPesoLessThan(Double preco, Double peso);
}
