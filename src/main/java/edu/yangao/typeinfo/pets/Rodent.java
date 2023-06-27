//: typeinfo/pets/Rodent.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Rodent extends Pet {
    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }

    public static class Factory implements TypesFactory<Rodent> {
        @Override
        public Rodent create() {
            return new Rodent();
        }

        @Override
        public Class<Rodent> type() {
            return Rodent.class;
        }
    }
} ///:~
