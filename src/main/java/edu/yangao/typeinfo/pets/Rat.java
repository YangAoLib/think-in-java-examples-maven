//: typeinfo/pets/Rat.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Rat extends Rodent {
  public Rat(String name) { super(name); }
  public Rat() { super(); }

    public static class Factory implements TypesFactory<Rat> {
        @Override
        public Rat create() {
        return new Rat();
        }

      @Override
      public Class<Rat> type() {
        return Rat.class;
      }
    }
} ///:~
