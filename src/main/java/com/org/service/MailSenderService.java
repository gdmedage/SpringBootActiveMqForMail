package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.org.wrapper.MessageWrapper;

@Component
public class MailSenderService {

  private JavaMailSender javaMailSender;


  @Autowired
  public MailSenderService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }


  /**
   * This function is used to send mail without attachment.This JavaMailSender Interface is used to
   * send Mail in Spring Boot. This JavaMailSender extends the MailSender Interface which contains
   * send() function. SimpleMailMessage Object is required because send() function uses object of
   * SimpleMailMessage as a Parameter
   * 
   * @param user
   * @throws MailException
   */
  @Async
  @JmsListener(destination = "xoriant.queue")
  public void receiveMessage(MessageWrapper messageWrapper) {

    String[] mailList = {"ganesh.medage@xoriant.com"};
    /*
     * This send() contains an Object of SimpleMailMessage as an Parameter
     */
    if (messageWrapper.getQuestionId() != 0) {
      SimpleMailMessage mail = new SimpleMailMessage();
      mail.setTo(mailList);
      // mail.setFrom("");
      mail.setSubject("Question Posted - Testing Mail API.");
      mail.setText(messageWrapper.getQuestionText());
      javaMailSender.send(mail);
      System.out.println("Mail Sent");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
