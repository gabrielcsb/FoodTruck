package br.com.tech4me.foodtruck.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.foodtruck.model.Pedidos;
import br.com.tech4me.foodtruck.repository.FoodTruckRepository;
import br.com.tech4me.foodtruck.shared.FoodTruckCompletoDto;
import br.com.tech4me.foodtruck.shared.FoodTruckDto;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {
  @Autowired
  private FoodTruckRepository repositorio;

  @Override
  public List<FoodTruckCompletoDto> obterTodas() {
    List<Pedidos> pedidos = repositorio.findAll();
    
    return pedidos.stream()
                .map(p -> new ModelMapper().map(p, FoodTruckCompletoDto.class))
                .collect(Collectors.toList());
  }

  @Override
  public Optional<FoodTruckDto> obterPorId(String id) {
    Optional<Pedidos> pedidos  = repositorio.findById(id);

    if (pedidos.isPresent()) {
      return Optional.of(new ModelMapper().map(pedidos.get(), FoodTruckDto.class));
    }
    return Optional.empty();
  }

  @Override
  public void excluirPorId(String id) {
    repositorio.deleteById(id);
  }

  @Override
  public FoodTruckCompletoDto cadastrar(FoodTruckCompletoDto dto) {
    Pedidos pedidos = new ModelMapper().map(dto, Pedidos.class);
    repositorio.save(pedidos);
    return new ModelMapper().map(pedidos, FoodTruckCompletoDto.class);  
  }

  @Override
  public Optional<FoodTruckCompletoDto> atualizarPorId(String id, FoodTruckCompletoDto dto) { 
    Optional<Pedidos> retorno = repositorio.findById(id);

    if (retorno.isPresent()) {
      Pedidos pedidos = new ModelMapper().map(dto, Pedidos.class);
      pedidos.setId(id);
      repositorio.save(pedidos);
      return Optional.of(new ModelMapper().map(pedidos, FoodTruckCompletoDto.class));
    } else {
      return Optional.empty();
    }
    
   
  }
  
}