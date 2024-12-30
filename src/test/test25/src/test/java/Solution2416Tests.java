import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2416Tests {
    private final Solution2416 solution2416 = new Solution2416();

    @Test
    public void example1() {
        String[] words = {"abc", "ab", "bc", "b"};
        int[] expected = {5, 4, 3, 2};
        Assertions.assertArrayEquals(expected, solution2416.sumPrefixScores(words));
    }

    @Test
    public void example2() {
        String[] words = {"abcd"};
        int[] expected = {4};
        Assertions.assertArrayEquals(expected, solution2416.sumPrefixScores(words));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/364256777/ TLE
        String[] words = UtUtils.loadingStrings("solution2416-example3-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution2416-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2416.sumPrefixScores(words));
    }
}
