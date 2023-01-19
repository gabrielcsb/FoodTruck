package br.com.tech4me.foodtruck.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4me.foodtruck.model.Pedidos;

public interface FoodTruckRepository extends MongoRepository<Pedidos, String> {
    
}
