package br.com.fiap.hackaton.msservicos.dto;

import br.com.fiap.hackaton.msservicos.entity.ServicoOpcional;
import br.com.fiap.hackaton.msservicos.enums.TipoServicosOpcionais;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ServicoOpcionalResponse {

    private Long id;
    private String nome;
    private double valor;
    @Enumerated(EnumType.STRING)
    private TipoServicosOpcionais tipo;

    public ServicoOpcionalResponse(ServicoOpcional servicoOpcional) {

        this.id   = servicoOpcional.getId();
        this.nome = servicoOpcional.getNome();
        this.tipo = servicoOpcional.getTipo();
        this.valor = servicoOpcional.getValor();

    }

}
