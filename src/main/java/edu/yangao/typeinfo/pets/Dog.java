//: typeinfo/pets/Dog.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public static class Factory implements TypesFactory<Dog> {

        @Override
        public Dog create() {
            return new Dog();
        }

        @Override
        public Class<Dog> type() {
            return Dog.class;
        }
    }
} ///:~
