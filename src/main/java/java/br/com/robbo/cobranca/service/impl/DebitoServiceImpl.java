package java.br.com.robbo.cobranca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.br.com.robbo.cobranca.dto.ConteudoEmailDTO;
import java.br.com.robbo.cobranca.entity.Debito;
import java.br.com.robbo.cobranca.repository.DebitoRepository;
import java.br.com.robbo.cobranca.service.DebitoService;
import java.br.com.robbo.cobranca.service.EmailService;
import java.util.List;

public class DebitoServiceImpl implements DebitoService {

    private static String subject = "Notificação de débitos em aberto";

    @Autowired
    private DebitoRepository debitoRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Debito> getDebitosAbertos() throws MessagingException {
        List<Debito> debitos = debitoRepository.findDebitoByDebitoAberto(Boolean.TRUE);
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
