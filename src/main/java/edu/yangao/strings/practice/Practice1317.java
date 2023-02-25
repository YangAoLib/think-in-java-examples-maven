package edu.yangao.strings.practice;

import edu.yangao.net.mindview.util.TextFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author YangAo
 */
public class Practice1317 {

    /**
     * 注释的匹配正则
     * <p>
     * 上一行的\n 会在下一行被 \\s 匹配, 所以这里只对空格进行匹配
     * <p>
     * 勉强型是相对于整个正则的, 并不是其针对的单个式子的勉强 （像 `.` 如果对其进行勉强型设置, 只会在整个匹配的情况下, 其选择最少的内容）
     */
    private static final Pattern EXEGESIS = Pattern.compile("^ *?((/\\*(.|\n)*?\\*/)|(//[^\n\r\f]*$))", Pattern.MULTILINE);

    /**
     * 匹配器
     */
    private static final Matcher MATCHER = EXEGESIS.matcher("");

    /**
     * 对前置空格进行匹配
     */
    private static final Matcher SPACE = Pattern.compile("\\s*").matcher("");

    /**
     * 文件路径
     */
    public static final String FILE_PATH = "src/main/java/edu/yangao/strings/practice/Practice1317.java";
    public static void main(String[] args) {
        for (String filePath : readFiles(FILE_PATH)) {
            MATCHER.reset(TextFile.read(filePath));
            // 遍历匹配文本中的注释
            while (MATCHER.find()) {
                // 存储生成后的注释
                StringBuilder stringBuilder = new StringBuilder();
                // 注释进行处理
                SPACE.reset(MATCHER.group());
                // 记录第一行空格的个数, 用于处理其他行
                int spaceCountFirst = 0;
                // 如果有空格 对其进行处理
                if (SPACE.find()) {
                    spaceCountFirst = SPACE.end() - SPACE.start();
                }
                // 根据空格数量进行新的匹配器的生成, 对整体每行前面的空格进行清除
                Matcher otherSpace = Pattern.compile(String.format("(?m)^\\s{%d}", spaceCountFirst))
                                        .matcher(MATCHER.group());
                while (otherSpace.find()) {
                    otherSpace.appendReplacement(stringBuilder, "");
                }
                otherSpace.appendTail(stringBuilder);
                // 输出结果
                System.out.println(stringBuilder);
            }
        }
    }

    /**
     * 根据传入的路径返回对应的文件数组, 会去除其中的目录
     * @param filePath 路径
     * @return 文件路径数组
     */
    public static List<String> readFiles(String filePath) {
        // 判断是否是文件夹, 然后进行文件数组的处理
        File argFile = new File(filePath);
        // 查询出来的文件列表
        List<File> fileList = argFile.isDirectory() ? List.of(argFile.listFiles()) : Collections.singletonList(argFile);
        // 文件绝对路径列表
        List<String> filePathList = new ArrayList<>(fileList.size());
        // 只把是文件的路径添加到路径列表中
        for (File file : fileList) {
            if (file.isFile()) {
                filePathList.add(file.getPath());
            }
        }
        return filePathList;
    }
}
