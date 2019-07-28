package org.xoriant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  private JavaMailSender javaMailSender;


  @Autowired
  public MailService(JavaMailSender javaMailSender) {
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
  public String sendEmail(String mailTo) throws MailException {

    /*
     * This JavaMailSender Interface is used to send Mail in Spring Boot. This JavaMailSender
     * extends the MailSender Interface which contains send() function. SimpleMailMessage Object is
     * required because send() function uses object of SimpleMailMessage as a Parameter
     */

    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(mailTo);
    mail.setFrom("ganesh.medage@xoriant.com");
    mail.setSubject("Testing Mail API");
    mail.setText("Hurray ! You have done that dude...");

    /*
     * This send() contains an Object of SimpleMailMessage as an Parameter
     */
    javaMailSender.send(mail);
    return "Congratulations! Your mail has been send.";
  }

  /**
   * This fucntion is used to send mail that contains a attachment.
   * 
   * @param user
   * @throws MailException
   * @throws MessagingException
   */
  /*
   * public void sendEmailWithAttachment(String mailTo) throws MailException, MessagingException {
   * 
   * MimeMessage mimeMessage = javaMailSender.createMimeMessage();
   * 
   * MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
   * 
   * helper.setTo(mailTo); helper.setFrom("ganesh.medage@xoriant.com");
   * helper.setSubject("Testing Mail API with Attachment");
   * helper.setText("Please find the attached document below.");
   * 
   * ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
   * helper.addAttachment(classPathResource.getFilename(), classPathResource);
   * 
   * javaMailSender.send(mimeMessage); }
   * 
   * 
   * 
   * public String send(String to, String from) { // Get system properties
   * 
   * Properties props = new Properties(); props.setProperty("mail.transport.protocol", "smtp");
   * props.setProperty("mail.host", "emailpun.xoriant.com"); props.setProperty("mail.user",
   * "emailuser"); props.setProperty("mail.password", ""); try { Session mailSession =
   * Session.getDefaultInstance(props, null); Transport transport = (Transport)
   * mailSession.getTransport();
   * 
   * InternetAddress internetAddress = new InternetAddress(to); internetAddress.validate();
   * 
   * MimeMessage message = new MimeMessage(mailSession); message.setFrom(new InternetAddress(from));
   * message.setSubject("Testing javamail plain"); message.setContent("This is a test",
   * "text/plain"); message.addRecipient(Message.RecipientType.TO, internetAddress);
   * 
   * transport.connect(); transport.sendMessage(message,
   * message.getRecipients(Message.RecipientType.TO)); transport.close();
   * 
   * } catch (Exception mex) {
   * System.out.println("Error in Send Email, Error while connecting to mail server:");
   * 
   * }
   * 
   * return "Email Sent successfully...."; }
   */
}
