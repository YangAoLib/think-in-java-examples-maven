package edu.yangao.generics;
//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

interface Payable<T> {}

public class MultipleInterfaceVariants {
    class Employee implements Payable<edu.yangao.generics.Employee> {}
    class Hourly extends edu.yangao.generics.Employee
            implements Payable<Hourly> {} ///:~
}
