package edu.yangao.strings.practice;

import edu.yangao.net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YangAo
 */
public class Practice1319 {

    /**
     * 注释的匹配正则
     */
    private static final Pattern EXEGESIS = Pattern.compile("\".*?\"", Pattern.MULTILINE);

    /**
     * 匹配器
     */
    private static final Matcher MATCHER = EXEGESIS.matcher("");

    /**
     * 文件路径
     */
    public static final String FILE_PATH = "src/main/java/edu/yangao/strings/practice/Practice1317.java";
    public static void main(String[] args) {
        for (String filePath : Practice1317.readFiles(FILE_PATH)) {
            MATCHER.reset(TextFile.read(filePath));
            while (MATCHER.find()) {
                System.out.println(MATCHER.group());
            }
        }
    }
}
