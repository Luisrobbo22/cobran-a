package java.br.com.robbo.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.br.com.robbo.cobranca.dto.ConteudoEmailDTO;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${suppot.mail}")
    private String supportMail;

    public void sendEmailToCliente(String subject, String email, ConteudoEmailDTO content) throws MessagingException {

        MimeMessage mail = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mail);
        message.setSubject(subject);
        message.setText(content.toString(), true);
        message.setFrom(supportMail);
        message.setTo(email);

        mailSender.send(mail);
    }

    public String getContenteEmail() {

    }
}
