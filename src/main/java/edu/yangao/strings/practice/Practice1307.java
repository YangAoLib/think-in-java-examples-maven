package edu.yangao.strings.practice;

/**
 * 第13章第7个练习
 * @author YangAo
 */
public class Practice1307 {
    public static void main(String[] args) {
        String regexp = "^[A-Z].*\\.";
        System.out.println("Anni.".matches(regexp));
        System.out.println("Anni".matches(regexp));
        System.out.println("anni.".matches(regexp));
    }
}
