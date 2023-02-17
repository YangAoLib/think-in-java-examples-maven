//: interfaces/filters/Filter.java
package edu.yangao.interfaces.filters;


public class Filter {
  public String name() {
    return getClass().getSimpleName();
  }
  public Waveform process(Waveform input) { return input; }
} ///:~
