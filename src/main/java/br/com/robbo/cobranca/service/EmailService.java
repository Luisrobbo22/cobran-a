package br.com.robbo.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import br.com.robbo.cobranca.dto.ConteudoEmailDTO;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${suppot.mail}")
    private String supportMail;

    public void sendEmailToCliente(String subject, String email, ConteudoEmailDTO conteudoEmailDTO) throws MessagingException {
        String content = getConteudoEmail(conteudoEmailDTO);

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mail);
        message.setSubject(subject);
        message.setText(content, true);
        message.setFrom(supportMail);
        message.setTo(email);

        mailSender.send(mail);
    }

    public String getConteudoEmail(ConteudoEmailDTO conteudoEmailDTO) {
        return "<p>Prezado cliente,</p>\n" +
                "<p>Identificamos um d&eacute;bito em aberto vencido no dia " + conteudoEmailDTO.getVencimento() + " no valor de R$ " + conteudoEmailDTO.getValor() + " </p>\n" +
                "<p>Descri&ccedil;&atilde;o do pagamento: " + conteudoEmailDTO.getDescricao() + "</p>\n";
    }
}
