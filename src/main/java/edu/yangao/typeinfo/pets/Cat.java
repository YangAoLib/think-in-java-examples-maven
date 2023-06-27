//: typeinfo/pets/Cat.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class Factory implements TypesFactory<Cat> {
        public Cat create() {
            return new Cat();
        }

        public Class<Cat> type() {
            return Cat.class;
        }
    }
} ///:~
