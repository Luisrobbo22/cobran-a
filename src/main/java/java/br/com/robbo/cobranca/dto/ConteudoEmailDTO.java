package java.br.com.robbo.cobranca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConteudoEmailDTO {

    private String descricao;
    private Calendar vencimento;
    private BigDecimal valor;
}
