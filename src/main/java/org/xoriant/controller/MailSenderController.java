package org.xoriant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xoriant.service.MailCreaterService;
import org.xoriant.wrapper.MessageWrapper;

@RestController
@RequestMapping("/mailsender")
public class MailSenderController {

  @Autowired
  MailCreaterService mailSenderService;

  @PostMapping(value = "/notify/question", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MessageWrapper> createMessage(
      @Valid @RequestBody(required = true) MessageWrapper messageWrapper) {

    return ResponseEntity.status(HttpStatus.CREATED).body(mailSenderService.send(messageWrapper));

  }

  public void sendMail() {

  }

}
