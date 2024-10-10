package com.mineda.avaliacao.entity;

import javax.print.attribute.standard.DateTimeAtCompleted;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "anc_anuncio")
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anc_id")
    private Long id;

    @Column(name = "anc_nome_produto")
    private String nomeProduto;

    @Column(name = "anc_data_hora")
    private DateTimeAtCompleted dataHora;

    @Column(name = "anc_descricao") 
    private String descricao;
        
    @Column(name = "anc_preco")
    private float preco;
        
    @Column (name = "anc_peso")
    private float peso;

        public Anuncio(){}

        public Anuncio(String nomeProduto, DateTimeAtCompleted dataHora, 
        String descricao,float preco,float peso){
            this();
            this.nomeProduto = nomeProduto;
            this.dataHora = dataHora;
            this.descricao = descricao;
            this.preco = preco;
            this.peso = peso;

        }
        public Long getId() {
        return id;
        }
        public void setId(Long id) {
        this.id = id;
        }
        public String getNomeProduto() {
            return nomeProduto;
        }
        public void setNome(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }
        
        public DateTimeAtCompleted getDataHora(){
            return dataHora;
        }
        public void setDataHora(DateTimeAtCompleted dataHora){
            this.dataHora = dataHora;
        }
        
        public String getDescricao(){
            return descricao;
        }
        public void setDescricao(String descricao){
            this.descricao = descricao;
        }

        public float getPreco(){
            return preco;
        }

        public void setPreco(float preco){
            this.preco = preco;
        }

        public float getPeso(){
            return peso;
        }
        public void setPeso(float peso){
            this.peso = peso;
        }


}
