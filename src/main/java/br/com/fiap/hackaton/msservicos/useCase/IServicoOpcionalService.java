package br.com.fiap.hackaton.msservicos.useCase;

import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalRequest;
import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalResponse;
import jakarta.transaction.Transactional;


import java.util.List;

public interface IServicoOpcionalService {

    public List<ServicoOpcionalResponse> listarTodos();

    @Transactional
    public ServicoOpcionalResponse adicionar(ServicoOpcionalRequest servicoOpcionalRequest);

    @Transactional
    public ServicoOpcionalResponse atualizar(Long id, ServicoOpcionalRequest servicoOpcionalRequest);

    @Transactional
    public void remover(Long id);

    public ServicoOpcionalResponse buscarPorId(Long id);

    public List<ServicoOpcionalResponse> buscarPorNome(String nome);

}
