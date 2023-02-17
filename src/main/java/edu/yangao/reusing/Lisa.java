package edu.yangao.reusing;
//: reusing/Lisa.java
// {CompileTimeError} (Won't compile)

class Lisa extends Homer {
  // TODO: 编译错误
  /* @Override */ void doh(Milhouse m) {
    System.out.println("doh(Milhouse)");
  }
} ///:~
