package br.com.robbo.cobranca.controller;

import br.com.robbo.cobranca.entity.Debito;
import br.com.robbo.cobranca.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(value = "/debito")
public class DebitoController {

    @Autowired
    private DebitoService debitoService;

    @GetMapping("/")
    public ResponseEntity<List<Debito>> getDebitosByEmailCliente() throws MessagingException {
        final List<Debito> debitos = debitoService.getDebitosAbertos();

        return ResponseEntity.ok().body(debitos);
    }
}
