package edu.yangao.generics;
//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)

// TODO: 因为编译错误 所以注释
/*
class Cat extends ComparablePet implements Comparable<Cat>{
  // Error: Comparable cannot be inherited with
  // different arguments: <Cat> and <Pet>
  public int compareTo(Cat arg) { return 0; }
} ///:~
//*/