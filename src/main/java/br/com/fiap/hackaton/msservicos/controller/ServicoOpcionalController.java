package br.com.fiap.hackaton.msservicos.controller;

import br.com.fiap.hackaton.msservicos.useCase.impl.ServicoOpcionalUseCase;
import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalRequest;
import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos-opcionais")
@AllArgsConstructor
public class ServicoOpcionalController {

    private ServicoOpcionalUseCase service;

    @GetMapping
    public ResponseEntity<List<ServicoOpcionalResponse>> listarTodos() {
        List<ServicoOpcionalResponse> servicos = service.listarTodos();

        return ResponseEntity.ok(servicos);
    }

    @PostMapping
    public ResponseEntity<ServicoOpcionalResponse> adicionarServicoOpcional(
            @RequestBody @Valid ServicoOpcionalRequest servicoOpcionalRequest) {

        return new ResponseEntity<>(service.adicionar(servicoOpcionalRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoOpcionalResponse> atualizarServicoOpcional(
            @PathVariable Long id,  @RequestBody @Valid ServicoOpcionalRequest servicoOpcionalRequest) {

        return new ResponseEntity<>(service.atualizar(id,servicoOpcionalRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerServicoOpcional(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoOpcionalResponse> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<ServicoOpcionalResponse>> buscarPorNome(@PathVariable String nome) {

        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

}
