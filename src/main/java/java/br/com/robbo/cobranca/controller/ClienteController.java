package java.br.com.robbo.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.br.com.robbo.cobranca.entity.Cliente;
import java.br.com.robbo.cobranca.repository.ClienteRepository;
import java.br.com.robbo.cobranca.service.ClienteService;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{email}")
    public ResponseEntity <List<Cliente>> getAllClientes(@PathVariable String email){
        final Cliente cliente = clienteService.getClienteByEmail(email);
        return ResponseEntity.ok().body(cliente);
    }
}
