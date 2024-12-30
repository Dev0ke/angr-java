import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution85Tests {
    private final Solution85 solution85 = new Solution85();

    @Test
    public void example1() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
                """);
        int expected = 6;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example2() {
        char[][] matrix = UtUtils.stringToChars2("""
                []
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example3() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["0"]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example4() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["1"]]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example5() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["0","0"]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    // 剑指 Offer II 040. 矩阵中最大的矩形
    // https://leetcode.cn/problems/PLYXKQ/
    @Test
    public void example1_2() {
        String[] matrix = {"10100", "10111", "11111", "10010"};
        int expected = 6;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example2_2() {
        String[] matrix = {};
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example3_2() {
        String[] matrix = {"0"};
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example4_2() {
        String[] matrix = {"1"};
        int expected = 1;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }

    @Test
    public void example5_2() {
        String[] matrix = {"00"};
        int expected = 0;
        Assertions.assertEquals(expected, solution85.maximalRectangle(matrix));
    }
}
