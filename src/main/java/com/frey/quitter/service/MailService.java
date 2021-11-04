package com.frey.quitter.service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.frey.quitter.exception.SpringQuitterException;
import com.frey.quitter.model.NotificationEmail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailService {

	private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    
    
    public MailService(JavaMailSender mailSender, MailContentBuilder mailContentBuilder) {
		this.mailSender = mailSender;
		this.mailContentBuilder = mailContentBuilder;
	}



	@Async
    void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("florian.rey1@gmail.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation email envoyé!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new SpringQuitterException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
        }
    }

}