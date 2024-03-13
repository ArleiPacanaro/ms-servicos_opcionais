package br.com.fiap.hackaton.msservicos.useCase.impl;

import br.com.fiap.hackaton.msservicos.useCase.IServicoOpcionalService;
import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalRequest;
import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalResponse;
import br.com.fiap.hackaton.msservicos.entity.ServicoOpcional;
import br.com.fiap.hackaton.msservicos.repository.ServicoOpcionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServicoOpcionalUseCase implements IServicoOpcionalService {

    private ServicoOpcionalRepository repository;


    @Override
    public List<ServicoOpcionalResponse> listarTodos() {

        var servicosEopcionais = repository.findAll();
        List<ServicoOpcionalResponse> servicoOpcionalResponses = new ArrayList<>();
        servicosEopcionais.forEach(sp -> servicoOpcionalResponses.add(new ServicoOpcionalResponse(sp)));
        return servicoOpcionalResponses;
    }

    @Override
    public ServicoOpcionalResponse adicionar(ServicoOpcionalRequest servicoOpcionalRequest) {
        ServicoOpcional servicoOpcional = new ServicoOpcional(servicoOpcionalRequest);
        return new ServicoOpcionalResponse(repository.save(servicoOpcional));
    }

    @Override
    public ServicoOpcionalResponse atualizar(Long id, ServicoOpcionalRequest servicoOpcionalRequest) {
        ServicoOpcional servicoOpcional = new ServicoOpcional(servicoOpcionalRequest);
        return new ServicoOpcionalResponse(repository.save(servicoOpcional));
    }

    @Override
    public void remover(Long id) {
         repository.deleteById(id);
    }

    @Override
    public ServicoOpcionalResponse buscarPorId(Long id) {
        return new ServicoOpcionalResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<ServicoOpcionalResponse> buscarPorNome(String nome) {
        var servicosEopcionais = repository.findByNomeLike(nome);
        List<ServicoOpcionalResponse> servicoOpcionalResponses = new ArrayList<>();
        servicosEopcionais.forEach(sp -> servicoOpcionalResponses.add(new ServicoOpcionalResponse(sp)));
        return servicoOpcionalResponses;
    }

}
