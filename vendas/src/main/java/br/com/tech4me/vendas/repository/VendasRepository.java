package br.com.tech4me.vendas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.vendas.model.Vendas;

public interface VendasRepository extends MongoRepository<Vendas,String> {
    
}
