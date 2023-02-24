package edu.yangao.strings;
//: strings/Groups.java

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static edu.yangao.net.mindview.util.Print.print;

public class Groups {
  static public final String POEM =
          """
                  Twas brillig, and the slithy toves
                  Did gyre and gimble in the wabe.
                  All mimsy were the borogoves,
                  And the mome raths outgrabe.

                  Beware the Jabberwock, my son,
                  The jaws that bite, the claws that catch.
                  Beware the Jubjub bird, and shun
                  The frumious Bandersnatch.""";
  public static void main(String[] args) {
    Matcher m =
      Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
        .matcher(POEM);
    HashMap<String, Integer> wordCountMap = new HashMap<>();
    while(m.find()) {
      // 1, 3, 4 为单词
      for(int j = 0; j <= m.groupCount(); j++) {
        if (j == 0 || j == 2) continue;
        // 当前组字符串内容
        String groupStr = m.group(j);
        System.out.printf("[%s] ", groupStr);
        // 是否首字母大写
        if (groupStr.matches("[^A-Z]\\w+")) {
          // 获取的值
          Integer getValue = wordCountMap.get(groupStr);
          // 判断值, 然后生成要存储的值
          Integer putValue = getValue == null ? 1 : getValue + 1;
          // 存储值
          wordCountMap.put(groupStr, putValue);
        }
      }
    }
    print();
    wordCountMap.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
  }
} /* Output:
[the slithy toves][the][slithy toves][slithy][toves]
[in the wabe.][in][the wabe.][the][wabe.]
[were the borogoves,][were][the borogoves,][the][borogoves,]
[mome raths outgrabe.][mome][raths outgrabe.][raths][outgrabe.]
[Jabberwock, my son,][Jabberwock,][my son,][my][son,]
[claws that catch.][claws][that catch.][that][catch.]
[bird, and shun][bird,][and shun][and][shun]
[The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch.]
*///:~
