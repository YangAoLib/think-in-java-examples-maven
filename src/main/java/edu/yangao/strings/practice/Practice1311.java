package edu.yangao.strings.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YangAo
 */
public class Practice1311 {
    public static void main(String[] args) {
        String regexp = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher("Arline ate eight apples and one orange while Anita hadn't any。");
        System.out.println(matcher.matches());
    }
}
