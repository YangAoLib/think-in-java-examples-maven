//: typeinfo/pets/EgyptianMau.java
package edu.yangao.typeinfo.pets;


import edu.yangao.typeinfo.factory.TypesFactory;

public class EgyptianMau extends Cat {
    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }

    public static class Factory implements TypesFactory<EgyptianMau> {
        public EgyptianMau create() {
            return new EgyptianMau();
        }

        public Class<EgyptianMau> type() {
            return EgyptianMau.class;
        }
    }
} ///:~
