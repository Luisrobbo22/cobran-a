package br.com.robbo.cobranca.repository;

import br.com.robbo.cobranca.entity.Debito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebitoRepository extends JpaRepository<Debito, Integer> {

    @Query("Select d from Debito d where d.isDebitoAberto = true")
    List<Debito> findDebitoByDebitoAberto();
}
