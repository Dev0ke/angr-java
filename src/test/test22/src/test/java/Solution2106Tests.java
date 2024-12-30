import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2106Tests {
    private final Solution2106 solution2106 = new Solution2106();

    @Test
    public void example1() {
        int[][] fruits = UtUtils.stringToInts2("[[2,8],[6,3],[8,6]]");
        int startPos = 5;
        int k = 4;
        int expected = 9;
        Assertions.assertEquals(expected, solution2106.maxTotalFruits(fruits, startPos, k));
    }

    @Test
    public void example2() {
        int[][] fruits = UtUtils.stringToInts2("[[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]]");
        int startPos = 5;
        int k = 4;
        int expected = 14;
        Assertions.assertEquals(expected, solution2106.maxTotalFruits(fruits, startPos, k));
    }

    @Test
    public void example3() {
        int[][] fruits = UtUtils.stringToInts2("[[0,3],[6,4],[8,5]]");
        int startPos = 3;
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2106.maxTotalFruits(fruits, startPos, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/247701618/
        // 182 / 202 个通过测试用例
        int[][] fruits = UtUtils.stringToInts2("[[0,7],[7,4],[9,10],[12,6],[14,8],[16,5],[17,8],[19,4],[20,1],[21,3],[24,3],[25,3],[26,1],[28,10],[30,9],[31,6],[32,1],[37,5],[40,9]]");
        int startPos = 21;
        int k = 30;
        int expected = 71;
        Assertions.assertEquals(expected, solution2106.maxTotalFruits(fruits, startPos, k));
    }
}