package edu.yangao.strings.practice;

/**
 * 第13章第6个练习
 * @author YangAo
 */
public class Practice1306 {
    public static void main(String[] args) {
        System.out.println(new TestObj());
    }

    private static class TestObj {
        int objInt = 1;
        long objLong = 2L;
        float objFloat = 3.1F;
        double objDouble = 3.2;

        @Override
        public String toString() {
            return String.format("TestObj{objInt=%d, objLong=%d, objFloat=%.2f, objDouble=%.2f}", objInt, objLong, objFloat, objDouble);
        }
    }
}

