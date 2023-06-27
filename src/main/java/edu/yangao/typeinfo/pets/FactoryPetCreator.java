package edu.yangao.typeinfo.pets;

import edu.yangao.typeinfo.factory.TypesFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author YangAo
 */
public class FactoryPetCreator extends PetCreator {
    static List<TypesFactory<? extends Pet>> petFactories =
            new ArrayList<>();

    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        petFactories.add(new Cat.Factory());
        petFactories.add(new Cymric.Factory());
        petFactories.add(new Dog.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Hamster.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Pug.Factory());
        petFactories.add(new Rat.Factory());
        petFactories.add(new Rodent.Factory());
    }

    private static Random rand = new Random(47);

    @Override
    public List<Class<? extends Pet>> types() {
        List<Class<? extends Pet>> types = new ArrayList<>();
        for (TypesFactory<? extends Pet> petFactory : petFactories) {
            types.add(petFactory.type());
        }
        return types;
    }
}
