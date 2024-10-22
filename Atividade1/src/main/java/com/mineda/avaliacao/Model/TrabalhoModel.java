package com.mineda.avaliacao.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "tra_trabalho")
public class TrabalhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    private int traId;

    @Column(name = "tra_titulo")
    private String traTitulo;

    @Column(name = "tra_data_hora_entrega")
    private LocalDateTime traDataHoraEntrega;
    
    @Column(name = "tra_descricao")
    private String traDescricao;

    @Column(name = "tra_grupo")
    private String traGrupo;

    @Column(name = "tra_nota")
    private Integer traNota;

    @Column(name = "tra_justificativa")
    private String traJustificativa;

    public TrabalhoModel(){}

    public TrabalhoModel (int traId, String traTitulo, LocalDateTime traDataHoraEntrega,
    String traDescricao, String traGrupo, Integer traNota, String traJustificativa){
        this.traId = traId;
        this.traTitulo = traTitulo;
        this.traDataHoraEntrega = traDataHoraEntrega;
        this.traDescricao = traDescricao;
        this.traGrupo = traGrupo;
        this.traNota = traNota;
        this.traJustificativa = traJustificativa;
    }

}


