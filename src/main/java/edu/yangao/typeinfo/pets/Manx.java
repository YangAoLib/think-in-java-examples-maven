//: typeinfo/pets/Manx.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Manx extends Cat {
    public Manx(String name) {
        super(name);
    }

    public Manx() {
        super();
    }

    public static class Factory implements TypesFactory<Manx> {
        @Override
        public Manx create() {
            return new Manx();
        }

        @Override
        public Class<Manx> type() {
            return Manx.class;
        }
    }
} ///:~
