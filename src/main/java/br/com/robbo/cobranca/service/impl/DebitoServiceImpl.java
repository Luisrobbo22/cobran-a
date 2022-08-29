package br.com.robbo.cobranca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import br.com.robbo.cobranca.dto.ConteudoEmailDTO;
import br.com.robbo.cobranca.entity.Debito;
import br.com.robbo.cobranca.repository.DebitoRepository;
import br.com.robbo.cobranca.service.DebitoService;
import br.com.robbo.cobranca.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitoServiceImpl implements DebitoService {

    private static String subject = "Notificação de débitos em aberto";

    @Autowired
    private DebitoRepository debitoRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Debito> getDebitosAbertos() throws MessagingException {
        List<Debito> debitos = debitoRepository.findDebitoByDebitoAberto();
        validaDadosEmail(debitos);
        return null;
    }

    private void validaDadosEmail(List<Debito> debitos) throws MessagingException {
       ConteudoEmailDTO conteudoEmailDTO = new ConteudoEmailDTO();

        for (Debito debito : debitos) {
            conteudoEmailDTO.setDescricao(debito.getDescricaoDebito());
            conteudoEmailDTO.setValor(debito.getValor());
            conteudoEmailDTO.setVencimento(debito.getVencimento());
            emailService.sendEmailToCliente(subject, debito.getCliente().getEmail(), conteudoEmailDTO);
        }
    }
}
