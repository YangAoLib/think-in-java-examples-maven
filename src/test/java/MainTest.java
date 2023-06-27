import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author YangAo
 */
public class MainTest {
    public static void main(String[] args) {
        String input = "C1bZc5A3wBa";
        System.out.println(convert(input));
    }

    public static String convert(String input) {
        int length = 52;
        char[] orderArray = new char[length];
        int start = 0;
        int startChar = 'a';
        int endChar = 'z';
        for (int i = 0; i < 13; ++i) {
            orderArray[start++] = (char) (startChar + i);
            orderArray[start++] = (char) (startChar + i - 32);
            orderArray[start++] = (char) (endChar - i);
            orderArray[start++] = (char) (endChar - i - 32);
        }
        String orderList = new String(orderArray);
        return input.chars().mapToObj(c -> (char) c).sorted(Comparator.comparingInt(item -> {
            int index = orderList.indexOf(item);
            return index == -1 ? length : index;
        })).map(String::valueOf).collect(Collectors.joining());
    }
}
