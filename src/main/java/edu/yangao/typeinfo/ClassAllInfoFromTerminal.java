package edu.yangao.typeinfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * 获取类的所有信息
 * 该类的名称来自命令行参数
 *
 * @author YangAo
 */
public class ClassAllInfoFromTerminal {

    public Class<?> temp;
    public Class<?> tempMethodClass;

    protected Integer testInteger;

    public class TestClass {
        static class TestTestClass {}
    }

    public interface TestInterface {}

    private ClassAllInfoFromTerminal() {}

    public ClassAllInfoFromTerminal(Integer testInteger) {
        this.testInteger = testInteger;
        class ConstructorClass implements TestInterface {
            public ConstructorClass() {}
            public ConstructorClass(Integer test) {
                System.out.println(test);
            }

            @Override
            public String toString() {
                return "constructor class";
            }
        }
        temp = ConstructorClass.class;
    }
    void testEnclosingMethod() {
        class MethodClass implements TestInterface {
            public MethodClass() {}
            public MethodClass(Integer test) {
                System.out.println(test);
            }

            @Override
            public String toString() {
                return "Method class";
            }
        }
        this.tempMethodClass = MethodClass.class;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (args.length == 0) {
            System.err.println("缺少命令行参数");
            return;
        }
        Class<?> argsClass = Class.forName(args[0]);
        ClassAllInfoFromTerminal info = new ClassAllInfoFromTerminal(1);
        System.out.println("============toGenericString=============");
        System.out.println(argsClass.toGenericString());
        System.out.println("==========descriptorString===============");
        System.out.println(argsClass.descriptorString());
        System.out.println("======getAnnotatedInterfaces========");
        for (AnnotatedType annotatedInterface : argsClass.getAnnotatedInterfaces()) {
            System.out.println(annotatedInterface);
        }
        System.out.println("=======getAnnotatedSuperclass============");
        System.out.println(argsClass.getAnnotatedSuperclass());
        System.out.println("=========getCanonicalName===============");
        System.out.println(argsClass.getCanonicalName());
        System.out.println("=======getClasses=================");
        for (Class<?> aClass : argsClass.getClasses()) {
            System.out.println(aClass.getName());
        }
        System.out.println("===========getConstructors==============");
        for (Constructor<?> constructor : argsClass.getConstructors()) {
            System.out.println(constructor.getName());
        }
        System.out.println("======getAnnotations=========");
        for (Annotation annotation : argsClass.getAnnotations()) {
            System.out.println(annotation);
        }
        System.out.println("======getDeclaredAnnotations=========");
        for (Annotation declaredAnnotation : argsClass.getDeclaredAnnotations()) {
            System.out.println(declaredAnnotation);
        }
        System.out.println("==========getDeclaredClasses============");
        for (Class<?> declaredClass : argsClass.getDeclaredClasses()) {
            System.out.println(declaredClass.getName());
        }
        System.out.println("=======getDeclaredConstructors=============");
        for (Constructor<?> declaredConstructor : argsClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);

        }
        System.out.println("===========getDeclaredFields===============");
        for (Field declaredField : argsClass.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("==========getDeclaredMethods=============");
        for (Method declaredMethod : argsClass.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
        System.out.println("==========getDeclaringClass============");
        System.out.println(info.temp.getDeclaringClass());
        System.out.println("=========getEnclosingClass==================");
        System.out.println(info.temp.getEnclosingClass());
        System.out.println("==========getEnclosingConstructor==========");
        System.out.println((info.temp.getEnclosingConstructor()));
        System.out.println("==========ClassAllInfoFromTerminal temp newInstance==========");
//        System.out.println(info.temp.getConstructor(info.getClass()).newInstance(info));
        System.out.println("=========getEnclosingMethod=========");
        info.testEnclosingMethod();
        System.out.println(info.tempMethodClass.getEnclosingMethod());
        System.out.println("========getEnumConstants==============");
        Object[] enumConstants = argsClass.getEnumConstants();
        System.out.println(Arrays.toString(enumConstants));
        if (Objects.nonNull(enumConstants)) {
            for (Object enumConstant : enumConstants) {
                System.out.println(enumConstant);
            }
        }
        System.out.println("============getFields===============");
        for (Field field : argsClass.getFields()) {
            System.out.println(field);
        }
        System.out.println("=====getGenericInterfaces=======");
        for (Type genericInterface : argsClass.getGenericInterfaces()) {
            System.out.println(genericInterface);
        }
        System.out.println("=========getGenericSuperclass=============");
        System.out.println(argsClass.getGenericSuperclass());
        System.out.println("============================================");
        for (Class<?> anInterface : argsClass.getInterfaces()) {
            System.out.println(anInterface);
        }
        System.out.println("==============getMethods================");
        for (Method method : argsClass.getMethods()) {
            System.out.println(method);
        }
        System.out.println("============getModifiers================");
        System.out.println(argsClass.getModifiers());
        System.out.println("============getModule====================");
        System.out.println(argsClass.getModule());
        System.out.println("===========getName======================");
        System.out.println(argsClass.getName());
        System.out.println("===========getNestHost===================");
        System.out.println(argsClass.getNestHost());
        System.out.println("==========getNestMembers===================");
        for (Class<?> nestMember : argsClass.getNestMembers()) {
            System.out.println(nestMember);
        }
        System.out.println("==========getPackage===================");
        System.out.println(argsClass.getPackage());
        System.out.println("=============getPackageName============");
        System.out.println(argsClass.getPackageName());
        System.out.println("=========getPermittedSubclasses===========");
        Class<?>[] permittedSubclasses = argsClass.getPermittedSubclasses();
        System.out.println(Arrays.toString(permittedSubclasses));
        if (Objects.nonNull(permittedSubclasses)) {
            for (Class<?> permittedSubclass : permittedSubclasses) {
                System.out.println(permittedSubclass);
            }
        }
        System.out.println("=========getProtectionDomain============");
        System.out.println(argsClass.getProtectionDomain());
        System.out.println("=======getRecordComponents===========");
        RecordComponent[] recordComponents = argsClass.getRecordComponents();
        System.out.println(Arrays.toString(recordComponents));
        if (Objects.nonNull(recordComponents)) {
            for (RecordComponent recordComponent : recordComponents) {
                System.out.println(recordComponent);
            }
        }
        System.out.println("========getSigners============");
        Object[] signers = argsClass.getSigners();
        System.out.println(Arrays.toString(signers));
        if (Objects.nonNull(signers)) {
            for (Object signer : signers) {
                System.out.println(signer);
            }
        }
        System.out.println("==============getSimpleName===============");
        System.out.println(argsClass.getSimpleName());
        System.out.println("============getSuperclass=================");
        System.out.println(argsClass.getSuperclass());
        System.out.println("============getTypeName==================");
        System.out.println(argsClass.getTypeName());
        System.out.println("=========isAnonymousClass================");
        System.out.println(argsClass.isAnonymousClass());
        System.out.println("===========isArray===================");
        System.out.println(argsClass.isArray());
        System.out.println("======isAssignableFrom(Object.class)=====");
        System.out.println(argsClass.isAssignableFrom(Object.class));
        System.out.println("========isEnum======================");
        System.out.println(argsClass.isEnum());
        System.out.println("===============isHidden==================");
        System.out.println(argsClass.isHidden());
        System.out.println("=============isInterface===============");
        System.out.println(argsClass.isInterface());
        System.out.println("============isLocalClass===============");
        System.out.println(info.temp.isLocalClass());
        System.out.println("============isMemberClass===============");
        System.out.println(argsClass.isMemberClass());
        System.out.println("============isPrimitive=================");
        System.out.println(argsClass.isPrimitive());
        System.out.println("============isRecord===================");
        System.out.println(argsClass.isRecord());
        System.out.println("============isSealed=================");
        System.out.println(argsClass.isSealed());
        System.out.println("==========toGenericString==========");
        System.out.println(argsClass.toGenericString());
        System.out.println("============getInterfaces============");
        System.out.println(Arrays.toString(argsClass.getInterfaces()));
        System.out.println("========================================");
        System.out.println("========================================");
        System.out.println("========================================");



    }
}
