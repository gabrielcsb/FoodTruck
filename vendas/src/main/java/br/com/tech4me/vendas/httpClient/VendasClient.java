package br.com.tech4me.vendas.httpClient;

import org.springframework.cloud.openfeign.FeignClient;

import br.com.tech4me.vendas.model.Pedidos;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pedido")
public interface VendasClient {
    
    @RequestMapping(method =RequestMethod.GET, value="/pedido/{id}")
   Pedidos obterVendas(@PathVariable String id);
}