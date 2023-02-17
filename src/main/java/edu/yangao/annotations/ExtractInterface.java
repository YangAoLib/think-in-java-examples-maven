//: annotations/ExtractInterface.java
// APT-based annotation processing.
package edu.yangao.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
  public String value();
} ///:~
