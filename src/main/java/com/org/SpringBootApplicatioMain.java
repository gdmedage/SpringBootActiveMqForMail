package com.org;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJms
public class SpringBootApplicatioMain {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicatioMain.class, args);
  }

  @Bean
  public Queue queue() {
    return new ActiveMQQueue("active.queue");
  }
}
