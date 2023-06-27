//: typeinfo/pets/Mutt.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Mutt extends Dog {
    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }

    public static class Factory implements TypesFactory<Mutt> {
        @Override
        public Mutt create() {
            return new Mutt();
        }

        @Override
        public Class<Mutt> type() {
            return Mutt.class;
        }
    }
} ///:~
