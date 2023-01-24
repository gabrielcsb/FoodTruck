package br.com.tech4me.vendas.service;


import java.util.List;
import java.util.Optional;
import br.com.tech4me.vendas.shared.VendasCompeloDto;
import br.com.tech4me.vendas.shared.VendasDto;

public interface VendasService {

    VendasCompeloDto CadastrarVendas(VendasCompeloDto dto);
    List<VendasDto>obterVendas();
    Optional<VendasDto> obterVendasPorId(String id);
    void excluirVendas(String id);
    Optional< VendasCompeloDto> atualizarVendasPorId(String id , VendasCompeloDto dto);
    
}
