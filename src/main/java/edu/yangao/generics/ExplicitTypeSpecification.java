package edu.yangao.generics;
//: generics/ExplicitTypeSpecification.java

import edu.yangao.net.mindview.util.New;
import edu.yangao.typeinfo.pets.Person;
import edu.yangao.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
