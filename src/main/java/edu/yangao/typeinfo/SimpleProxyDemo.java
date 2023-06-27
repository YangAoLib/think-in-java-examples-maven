package edu.yangao.typeinfo;
//: typeinfo/SimpleProxyDemo.java

import java.util.HashMap;
import java.util.Map;

import static edu.yangao.net.mindview.util.Print.print;

interface Interface {
  void doSomething();
  void somethingElse(String arg);
}

class RealObject implements Interface {
  public void doSomething() { print("doSomething"); }
  public void somethingElse(String arg) {
    print("somethingElse " + arg);
  }
}	

class SimpleProxy implements Interface {
  private Interface proxied;
  private Map<String, Integer> methodCallCount = new HashMap<>();

  public SimpleProxy(Interface proxied) {
    this.proxied = proxied;
  }
  public void doSomething() {
    print("SimpleProxy doSomething");
    proxied.doSomething();
    Integer doSomethingMethodCount = methodCallCount.get("doSomething");
    if (doSomethingMethodCount == null) {
      methodCallCount.put("doSomething", 1);
    } else {
      methodCallCount.put("doSomething", doSomethingMethodCount + 1);
    }
  }
  public void somethingElse(String arg) {
    print("SimpleProxy somethingElse " + arg);
    proxied.somethingElse(arg);
    Integer somethingElseCount = methodCallCount.get("somethingElse");
    if (somethingElseCount == null) {
      methodCallCount.put("somethingElse", 1);
    } else {
      methodCallCount.put("somethingElse", somethingElseCount + 1);
    }
  }

  public void printMethodCount() {
    for (Map.Entry<String, Integer> methodCallCount : methodCallCount.entrySet()) {
      System.out.println(String.format("方法: %s被调用了%d次", methodCallCount.getKey(), methodCallCount.getValue()));
    }
  }
}	

class SimpleProxyDemo {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.doSomething();
    iface.doSomething();
    iface.somethingElse("bonobo");
    iface.somethingElse("bonobo");
    iface.somethingElse("bonobo");
    iface.somethingElse("bonobo");
  }
  public static void main(String[] args) {
    RealObject proxied = new RealObject();
    consumer(proxied);
    SimpleProxy proxy = new SimpleProxy(proxied);
    consumer(proxy);
    proxy.printMethodCount();
  }
} /* Output:
doSomething
somethingElse bonobo
SimpleProxy doSomething
doSomething
SimpleProxy somethingElse bonobo
somethingElse bonobo
*///:~
