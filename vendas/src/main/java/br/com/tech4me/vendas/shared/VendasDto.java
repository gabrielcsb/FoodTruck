package br.com.tech4me.vendas.shared;

import br.com.tech4me.vendas.model.Pedidos;

public class VendasDto {

    private String id;
    private String idVenda;
    private Pedidos dadosPedidos;
    private String observacao;
    private Double tempoEspera;
    
    

    public Pedidos getDadosPedidos() {
        return dadosPedidos;
    }
    public void setDadosPedidos(Pedidos dadosPedidos) {
        this.dadosPedidos = dadosPedidos;
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
    public String getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }
    
}
