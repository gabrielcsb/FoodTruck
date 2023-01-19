package br.com.tech4me.foodtruck.service;

import java.util.List;
import java.util.Optional;
import br.com.tech4me.foodtruck.shared.FoodTruckCompletoDto;
import br.com.tech4me.foodtruck.shared.FoodTruckDto;


public interface FoodTruckService {
  List<FoodTruckCompletoDto> obterTodas();
  Optional<FoodTruckDto> obterPorId(String id);
  void excluirPorId(String id);
  FoodTruckCompletoDto cadastrar(FoodTruckCompletoDto dto);
  Optional<FoodTruckCompletoDto> atualizarPorId(String id, FoodTruckCompletoDto dto);
}