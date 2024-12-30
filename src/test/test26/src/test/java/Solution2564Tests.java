import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2564Tests {
    private final Solution2564 solution2564 = new Solution2564();

    @Test
    public void example1() {
        String s = "101101";
        int[][] queries = UtUtils.stringToInts2("[[0,5],[1,2]]");
        int[][] expected = UtUtils.stringToInts2("[[0,2],[2,3]]");
        Assertions.assertArrayEquals(expected, solution2564.substringXorQueries(s, queries));
    }

    @Test
    public void example2() {
        String s = "0101";
        int[][] queries = UtUtils.stringToInts2("[[12,8]]");
        int[][] expected = UtUtils.stringToInts2("[[-1,-1]]");
        Assertions.assertArrayEquals(expected, solution2564.substringXorQueries(s, queries));
    }

    @Test
    public void example3() {
        String s = "1";
        int[][] queries = UtUtils.stringToInts2("[[4,5]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0]]");
        Assertions.assertArrayEquals(expected, solution2564.substringXorQueries(s, queries));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/402695781/ TLE
        final String fileName = "solution2564-example4-input.txt";
        String s = UtUtils.loadingString(fileName, 0);
        int[][] queries = UtUtils.loadingInts2(fileName, 1);
        int[][] expected = UtUtils.loadingInts2("solution2564-example4-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2564.substringXorQueries(s, queries));
    }
}