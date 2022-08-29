package br.com.robbo.cobranca.repository;

import br.com.robbo.cobranca.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByEmail(String email);
}
