package br.com.tech4me.vendas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.vendas.httpClient.VendasClient;
import br.com.tech4me.vendas.model.Vendas;
import br.com.tech4me.vendas.repository.VendasRepository;
import br.com.tech4me.vendas.shared.VendasCompeloDto;
import br.com.tech4me.vendas.shared.VendasDto;

@Service
public class VendasServiceImp implements VendasService {

    @Autowired
    private VendasRepository repository;

    @Autowired
    private VendasClient vendasClient;
    

    @Override
    public VendasCompeloDto CadastrarVendas(VendasCompeloDto dto) {
        Vendas vendas = new ModelMapper().map(dto, Vendas.class);

        repository.save(vendas);
        return new ModelMapper().map(vendas,VendasCompeloDto.class);
    }

    @Override
    public List<VendasCompeloDto> obterVendas() {
        List<Vendas> vendas = repository.findAll();
        List<VendasCompeloDto> dto = vendas.stream()
        .map(p -> new ModelMapper().map(p, VendasCompeloDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public Optional<VendasDto> obterVendasPorId(String id) {
        Optional<Vendas> vendas = repository.findById(id);

        if(vendas.isPresent()){
            VendasDto vendas2 = new ModelMapper().map(vendas, VendasDto.class);
          vendas2.setDadosPedidos(vendasClient.obterVendas(vendas2.getIdVenda())); 

            return Optional.of(vendas2);
        }
        return Optional.empty();
    }

    @Override
    public void excluirVendas(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public Optional<VendasDto> atualizarVendasPorId(String id, VendasDto dto) {
        Optional<Vendas> retorno = repository.findById(id);

        if(retorno.isPresent()){
            Vendas vendasRetorno = new ModelMapper()
            .map(dto, Vendas.class);
            vendasRetorno.setId(id);
            repository.save(vendasRetorno);
            return Optional.of(new ModelMapper().map(vendasRetorno, VendasDto.class));
        }
        return Optional.empty();
    }

 
    
}