package edu.yangao.strings;
//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: src/main/java/edu/yangao/strings/JGrep.java "^\s*\b[sct]\w+" 2}
// {Args: src/main/java/edu/yangao/strings/JGrep.java "^\s*\b[sct]\w+" 10}
// {Args: src/main/java/edu/yangao/strings/ ^\s*\b[sct]\w+ 2}
// {Args: src/main/java/edu/yangao/strings/ ^\s*\b[sct]\w+ 10}

import edu.yangao.net.mindview.util.TextFile;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
  public static void main(String[] args) throws Exception {
    if(args.length < 2) {
      System.out.println("Usage: java JGrep file regex");
      System.exit(0);
    }
    // 第三个参数 将想要设置的模式 数值相加写上及可
    Pattern p = Pattern.compile(args[1], Integer.parseInt(args[2]));
    // Iterate through the lines of the input file:
    int index = 0;
    Matcher m = p.matcher("");

    // 判断传入的是否是文件夹, 然后进行处理
    File argFile = new File(args[0]);
    List<File> fileList = argFile.isDirectory() ? List.of(argFile.listFiles()) : Collections.singletonList(argFile);
    // 按 列表进行 文件内容的读取
    for (File singleFile : fileList) {
      // 只对文件进行读取, 跳过目录
      if (singleFile.isDirectory()) continue;
      for(String line : new TextFile(singleFile.getPath())) {
        m.reset(line);
        while(m.find())
          System.out.println(index++ + ": " + m.group() + ": " + m.start());
      }
    }
    // 重新记数
    index = 0;
    for (File singleFile : fileList) {
      // 只对文件进行读取, 跳过目录
      if (singleFile.isDirectory()) continue;
      m.reset(TextFile.read(singleFile.getPath()));
      while (m.find()) {
        System.out.println(index++ + ": " + m.group() + ": " + m.start());
      }
    }
  }
} /* Output: (Sample)
0: strings: 4
1: simple: 10
2: the: 28
3: Ssct: 26
4: class: 7
5: static: 9
6: String: 26
7: throws: 41
8: System: 6
9: System: 6
10: compile: 24
11: through: 15
12: the: 23
13: the: 36
14: String: 8
15: System: 8
16: start: 31
*///:~
