package edu.yangao.generics;
//: generics/SimplerPets.java

import edu.yangao.net.mindview.util.New;
import edu.yangao.typeinfo.pets.Person;
import edu.yangao.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~
