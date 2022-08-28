package java.br.com.robbo.cobranca.service;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.br.com.robbo.cobranca.entity.Cliente;
import java.br.com.robbo.cobranca.entity.Debito;
import java.util.List;

@Service
public interface DebitoService {
    List<Debito> getDebitosAbertos() throws MessagingException;
}
