package edu.yangao.strings.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YangAo
 */
public class Practice1310 {
    public static void main(String[] args) {
        String str = "Java now has regular expressions";
        String[] regexpList = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s{4}", "s{1}", "s{0,3}"};
        for (String regexp :
                regexpList) {
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(str);
            System.out.println(matcher.find());
        }
    }
}
