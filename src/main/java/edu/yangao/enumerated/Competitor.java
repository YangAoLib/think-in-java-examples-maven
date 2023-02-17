//: enumerated/Competitor.java
// Switching one enum on another.
package edu.yangao.enumerated;


public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
