//: typeinfo/pets/Hamster.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Hamster extends Rodent {
    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
        super();
    }

    public static class Factory implements TypesFactory<Hamster> {

        @Override
        public Hamster create() {
            return new Hamster();
        }

        @Override
        public Class<Hamster> type() {
            return Hamster.class;
        }
    }
} ///:~
