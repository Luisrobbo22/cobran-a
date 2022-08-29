package br.com.robbo.cobranca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_debito")
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ds_debito")
    private String descricaoDebito;

    @Column(name = "dt_vencimento")
    private Calendar vencimento;

    private BigDecimal valor;

    private boolean isDebitoAberto = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cliente cliente;

}