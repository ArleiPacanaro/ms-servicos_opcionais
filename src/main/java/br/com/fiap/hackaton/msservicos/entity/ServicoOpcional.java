package br.com.fiap.hackaton.msservicos.entity;

import br.com.fiap.hackaton.msservicos.dto.ServicoOpcionalRequest;
import br.com.fiap.hackaton.msservicos.enums.TipoServicosOpcionais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name="TB_SERVICO_OPCIONAL")
public class ServicoOpcional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valor;
    @Enumerated(EnumType.STRING)
    private TipoServicosOpcionais tipo;

    public ServicoOpcional(ServicoOpcionalRequest servicoOpcionalRequest) {

        this.nome = servicoOpcionalRequest.getNome();
        this.tipo = servicoOpcionalRequest.getTipo();

        if(Double.compare(servicoOpcionalRequest.getValor(), tipo.getvalorMinimo()) < 0 )
            throw new IllegalArgumentException("Valor menor que o padronizado");

        this.valor = servicoOpcionalRequest.getValor();

    }
}