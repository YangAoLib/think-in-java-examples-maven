package edu.yangao.typeinfo;
//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

import java.util.Arrays;
import java.util.List;

import static edu.yangao.net.mindview.util.Print.print;

class Candy {
    static {
        print("Loading Candy");
    }
}

class Gum {
    static {
        print("Loading Gum");
    }
}

class Cookie {
    static {
        print("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        solution(args);
    }

    public static void solution(String[] args) {
        if (args.length < 1) {
            System.out.println("缺少参数");
            return;
        }
        System.out.println("开始加载");
        try {
            Class.forName("edu.yangao.typeinfo." + args[0]);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("完成加载");
    }

    public static void solutionOriginal(String[] args) {
        List<String> classList = Arrays.stream(args).toList();
        if (classList.contains(Candy.class.getSimpleName())) {
            print("inside main");
            new Candy();
            print("After creating Candy");
        }

        if (classList.contains(Gum.class.getSimpleName())) {
            try {
                Class.forName("Gum");
            } catch (ClassNotFoundException e) {
                print("Couldn't find Gum");
            }
            print("After Class.forName(\"Gum\")");
        }
        if (classList.contains(Cookie.class.getSimpleName())) {
            new Cookie();
            print("After creating Cookie");
        }
    }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
