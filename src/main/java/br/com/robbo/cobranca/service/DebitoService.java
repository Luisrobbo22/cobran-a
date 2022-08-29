package br.com.robbo.cobranca.service;

import br.com.robbo.cobranca.entity.Debito;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

public interface DebitoService {
    List<Debito> getDebitosAbertos() throws MessagingException;
}
