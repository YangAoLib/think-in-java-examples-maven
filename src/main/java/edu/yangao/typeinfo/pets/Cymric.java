//: typeinfo/pets/Cymric.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }

    public static class Factory implements TypesFactory<Cymric> {

        @Override
        public Cymric create() {
            return new Cymric();
        }

        @Override
        public Class<Cymric> type() {
            return Cymric.class;
        }
    }
} ///:~
