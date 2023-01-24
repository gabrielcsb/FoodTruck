package br.com.tech4me.vendas.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.tech4me.vendas.service.VendasService;
import br.com.tech4me.vendas.shared.VendasCompeloDto;
import br.com.tech4me.vendas.shared.VendasDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendasController {
    @Autowired
    private VendasService servico;

    //Cadastrar pedido
    @PostMapping
    public ResponseEntity<VendasCompeloDto> cadastrarVendas(@RequestBody @Valid VendasCompeloDto pedido)
    {
        return new ResponseEntity<>(servico.CadastrarVendas(pedido),HttpStatus.CREATED);
    }

    //Buscar vendas
    @GetMapping
    public ResponseEntity<List<VendasDto>> obterVendas()
    {
        return new ResponseEntity<>(servico.obterVendas(),HttpStatus.OK);
    } 

    //Buscar venda por id
    @GetMapping("/{id}")
    public ResponseEntity<VendasDto> obterVendasPorId(@PathVariable String id)
    {
        Optional<VendasDto> retorno = servico.obterVendasPorId(id);
        
        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }

    //Deletar venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVendas(@PathVariable String id)
    {
        servico.excluirVendas(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Atualizar venda
    @PutMapping("/{id}")
    public ResponseEntity<VendasCompeloDto> atualizarVendas(@PathVariable String id,@RequestBody @Valid VendasCompeloDto pedido){
        Optional<VendasCompeloDto> retorno = servico.atualizarVendasPorId(id, pedido);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    } 
    
}
