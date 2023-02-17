//: interfaces/interfaceprocessor/Apply.java
package edu.yangao.interfaces.interfaceprocessor;

import static edu.yangao.net.mindview.util.Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~
