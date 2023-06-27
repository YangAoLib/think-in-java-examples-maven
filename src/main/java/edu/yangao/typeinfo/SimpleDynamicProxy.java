package edu.yangao.typeinfo;
//: typeinfo/SimpleDynamicProxy.java
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

class DynamicProxyHandler implements InvocationHandler {
  private Object proxied;
  private Map<String, Integer> methodCallCount = new HashMap<>();
  public DynamicProxyHandler(Object proxied) {
    this.proxied = proxied;
  }
  public Object
  invoke(Object proxy, Method method, Object[] args)
  throws Throwable {
    System.out.println("**** proxy: " + proxy.getClass() +
      ", method: " + method + ", args: " + args);
    if(args != null)
      for(Object arg : args)
        System.out.println("  " + arg);
    String methodName = method.getName();
    methodCallCount.merge(methodName, 1, Integer::sum);
    return method.invoke(proxied, args);
  }

  public void printMethodCount() {
    for (Map.Entry<String, Integer> methodCallCount : methodCallCount.entrySet()) {
      System.out.printf("方法: %s被调用了%d次%n", methodCallCount.getKey(), methodCallCount.getValue());
    }
  }
}

class SimpleDynamicProxy {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.doSomething();
    iface.somethingElse("bonobo");
    iface.somethingElse("bonobo");
    iface.somethingElse("bonobo");
    iface.somethingElse("bonobo");
  }
  public static void main(String[] args) {
    RealObject real = new RealObject();
    consumer(real);
    // Insert a proxy and call again:
    DynamicProxyHandler proxyHandler = new DynamicProxyHandler(real);
    Interface proxy = (Interface)Proxy.newProxyInstance(
      Interface.class.getClassLoader(),
      new Class[]{ Interface.class },
      proxyHandler);
    consumer(proxy);
    proxyHandler.printMethodCount();
  }
} /* Output: (95% match)	
doSomething
somethingElse bonobo
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
doSomething
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
  bonobo
somethingElse bonobo
*///:~
