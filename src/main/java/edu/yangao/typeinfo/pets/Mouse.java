//: typeinfo/pets/Mouse.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Mouse extends Rodent {
    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }

    public static class Factory implements TypesFactory<Mouse> {
        @Override
        public Mouse create() {
            return new Mouse();
        }

        @Override
        public Class<Mouse> type() {
            return Mouse.class;
        }
    }
} ///:~
