package com.mineda.Atividade2.Model;

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

@Table(name = "anc_anuncio")
public class AnuncioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anc_id")
    private int ancId;

    @Column(name = "anc_nome_produto")
    private String ancNomeProduto;

    @Column(name = "anc_descricao")
    private String ancDescricao;

    @Column(name = "anc_data_hora")
    private LocalDateTime ancDataHora; //

    @Column(name = "anc_preco")
    private double ancPreco;

    @Column(name = "anc_peso")
    private double ancPeso;

    public AnuncioModel(){}

    public AnuncioModel (int ancId, String ancNomeProduto, String ancDescricao, 
    LocalDateTime ancDataHora, double ancPreco, double ancPeso){
        this.ancId = ancId;
        this.ancNomeProduto = ancNomeProduto;
        this.ancDescricao = ancDescricao;
        this.ancDataHora = ancDataHora;
        this.ancPreco = ancPreco;
        this.ancPeso = ancPeso;

    }


}
