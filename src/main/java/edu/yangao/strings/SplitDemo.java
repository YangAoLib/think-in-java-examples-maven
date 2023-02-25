package edu.yangao.strings;
//: strings/SplitDemo.java

import java.util.Arrays;

import static edu.yangao.net.mindview.util.Print.print;

public class SplitDemo {
  public static void main(String[] args) {
    String input =
      "This!!unusual use!!of exclamation!!points";
    print(Arrays.toString(
      input.split("!!")));
    // Only do the first three:
    print(Arrays.toString(
            input.split("!!", 3)));
  }
} /* Output:
[This, unusual use, of exclamation, points]
[This, unusual use, of exclamation!!points]
*///:~
