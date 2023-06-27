//: typeinfo/pets/Pug.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }

    public static class Factory implements TypesFactory<Pug> {
        @Override
        public Pug create() {
            return new Pug();
        }

        @Override
        public Class<Pug> type() {
            return Pug.class;
        }
    }
} ///:~
