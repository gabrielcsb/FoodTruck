package br.com.tech4me.vendas.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("vendas")
public class Vendas {

@Id
    private String id;
    private String observacao;
    private Double tempoEspera;
    private String idVenda;
    private Double valor;


    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Double getTempoEspera() {
        return tempoEspera;
    }
    public void setTempoEspera(Double tempoEspera) {
        this.tempoEspera = tempoEspera;
    }
    
}
