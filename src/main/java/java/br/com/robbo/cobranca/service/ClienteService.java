package java.br.com.robbo.cobranca.service;

import org.springframework.stereotype.Service;

import java.br.com.robbo.cobranca.entity.Cliente;

@Service
public interface ClienteService {
    Cliente getClienteByEmail(String email);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(String email, Cliente newCliente);
}
