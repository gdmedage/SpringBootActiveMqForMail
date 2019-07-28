package com.org.wrapper;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageWrapper implements Serializable {

  /**
   * SerialVersionUID
   */
  private static final long serialVersionUID = 1881085568366904200L;
  private long questionId;
  private String questionText;
}
