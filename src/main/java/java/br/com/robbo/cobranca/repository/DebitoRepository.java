package java.br.com.robbo.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.br.com.robbo.cobranca.entity.Debito;
import java.util.List;

@Repository
public interface DebitoRepository extends JpaRepository<Debito, Integer> {

    List<Debito> findDebitoByDebitoAberto(Boolean aberto);
}
