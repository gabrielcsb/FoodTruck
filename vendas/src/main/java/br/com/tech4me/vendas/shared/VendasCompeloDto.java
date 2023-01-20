package br.com.tech4me.vendas.shared;

import jakarta.validation.constraints.Positive;

public class VendasCompeloDto {

    private String id;
    private String observacao;
    private Double tempoEspera;
    private String idVenda;
    @Positive
    private Double valor;

    
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
    public String getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
