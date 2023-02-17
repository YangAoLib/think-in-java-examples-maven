//: annotations/Testable.java
package edu.yangao.annotations;

import edu.yangao.net.mindview.atunit.*;

public class Testable {
  public void execute() {
    System.out.println("Executing..");
  }
  @Test void testExecute() { execute(); }
} ///:~
