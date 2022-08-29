package br.com.robbo.cobranca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(env.getProperty("spring.mail.port", Integer.class));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
        mailSender.setProtocol(env.getProperty("spring.mail.protocol"));

        Properties props = new Properties();

        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.connection-timeout",10000);

        mailSender.setJavaMailProperties(props);

        return mailSender;
    }
}
