package br.com.tech4me.foodtruck.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.foodtruck.service.FoodTruckService;
import br.com.tech4me.foodtruck.shared.FoodTruckCompletoDto;
import br.com.tech4me.foodtruck.shared.FoodTruckDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class FoodTruckController {
  @Autowired
  private FoodTruckService servico;
  

  @PostMapping
  public ResponseEntity<FoodTruckCompletoDto> cadastrarPedido(@RequestBody @Valid FoodTruckCompletoDto pedido){
    return new ResponseEntity<>(servico.cadastrar(pedido), HttpStatus.CREATED); 
  }

  @GetMapping
  public ResponseEntity<List<FoodTruckCompletoDto>> obterPedido() {
    return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FoodTruckDto> obterPedidoPorId(@PathVariable String id) {
    Optional<FoodTruckDto> retorno = servico.obterPorId(id);

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirPedido(@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<FoodTruckCompletoDto> atualizarPedido(@PathVariable String id, @RequestBody FoodTruckCompletoDto pedido){
    Optional<FoodTruckCompletoDto> retorno = servico.atualizarPorId(id, pedido); 

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
   
  }
  
    @GetMapping("/porta")
    public String obterPorta(@Value("${local.server.port}") String porta){
      return "A instância que respondeu a requisição está rodando na porta" +porta;
    }

    

}
