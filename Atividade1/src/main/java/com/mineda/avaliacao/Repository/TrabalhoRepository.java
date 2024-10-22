package com.mineda.avaliacao.Repository;

import java.util.List; // Importação correta
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; // Importação correta
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mineda.avaliacao.Model.TrabalhoModel;

@Repository
public interface TrabalhoRepository extends JpaRepository<TrabalhoModel, Integer> {
    // Consulta personalizada com @Query


    @Query("SELECT t FROM TrabalhoModel t WHERE t.traTitulo like %:titulo% and t.traNota >= :notaMinima")
    Optional<TrabalhoModel> findTrabalhosByTituloAndNotaMinima(@Param("titulo") String titulo,
     @Param("notaMinima") Integer notaMinima);
}
