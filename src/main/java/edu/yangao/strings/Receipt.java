package edu.yangao.strings;
//: strings/Receipt.java

import java.util.Formatter;

public class Receipt {
  private double total = 0;
  private final Formatter f = new Formatter(System.out);

  /**
   * 名称长度
   */
  private final Integer NAME_LENGTH = 15;

  /**
   * 名称最多显示字符数量
   */
  private final Integer NAME_MAX_LENGTH = 15;

  /**
   * qty 长度
   */
  private final Integer QTY_LENGTH = 5;

  /**
   * 价格长度
   */
  private final Integer PRICE_LENGTH = 10;

  /**
   * 价格小数点后长度
   */
  private final Integer PRICE_POINT_LENGTH = 2;

  public void printTitle() {
    // item长度
    Integer itemLength = 15;
    // 格式用字符串
    String formatString = String.format("%%-%ds %%%ds %%%ds\n", itemLength, QTY_LENGTH, PRICE_LENGTH);
    f.format(formatString, "Item", "Qty", "Price");
    f.format(formatString, "----", "---", "-----");
  }
  public void print(String name, int qty, double price) {
    // 格式用字符串
    String formatString = String.format("%%-%d.%ds %%%dd %%%d.%df\n", NAME_LENGTH, NAME_MAX_LENGTH, QTY_LENGTH, PRICE_LENGTH, PRICE_POINT_LENGTH);
    f.format(formatString, name, qty, price);
    total += price;
  }
  public void printTotal() {
    // 格式用字符串
    String formatString = String.format("%%-%d.%ds %%%ds %%%d.%df\n", NAME_LENGTH, NAME_MAX_LENGTH, QTY_LENGTH, PRICE_LENGTH, PRICE_POINT_LENGTH);
    String formatStringSecond = String.format("%%-%ds %%%ds %%%ds\n", NAME_LENGTH, QTY_LENGTH, PRICE_LENGTH);
    f.format(formatString, "Tax", "", total*0.06);
    f.format(formatStringSecond, "", "", "-----");
    f.format(formatString, "Total", "",
      total * 1.06);
  }
  public static void main(String[] args) {
    Receipt receipt = new Receipt();
    receipt.printTitle();
    receipt.print("Jack's Magic Beans", 4, 4.25);
    receipt.print("Princess Peas", 3, 5.1);
    receipt.print("Three Bears Porridge", 1, 14.29);
    receipt.printTotal();
  }
} /* Output:
Item              Qty      Price
----              ---      -----
Jack's Magic Be     4       4.25
Princess Peas       3       5.10
Three Bears Por     1      14.29
Tax                         1.42
                           -----
Total                      25.06
*///:~
