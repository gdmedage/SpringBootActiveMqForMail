package org.xoriant.service;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.xoriant.wrapper.MessageWrapper;

@Component
public class MailCreaterService {
  private static final Logger LOG = LoggerFactory.getLogger(MailCreaterService.class);

  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;

  @Autowired
  private Queue queue;


  public MessageWrapper send(MessageWrapper messageWrapper) {
    // This will put text message to queue

    this.jmsMessagingTemplate.convertAndSend(this.queue, messageWrapper);
    LOG.info("Message has been put to queue by sender");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      LOG.error("Interrupted Exception. {}", ex);
    }
    return messageWrapper;
  }
}
