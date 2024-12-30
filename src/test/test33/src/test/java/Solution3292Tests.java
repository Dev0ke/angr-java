import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3292Tests {
    private final Solution3292 solution3292 = new Solution3292();

    @Test
    public void example1() {
        String[] words = {"abc", "aaaaa", "bcdef"};
        String target = "aabcdabc";
        int expected = 3;
        Assertions.assertEquals(expected, solution3292.minValidStrings(words, target));
    }

    @Test
    public void example2() {
        String[] words = {"abababab", "ab"};
        String target = "ababaababa";
        int expected = 2;
        Assertions.assertEquals(expected, solution3292.minValidStrings(words, target));
    }

    @Test
    public void example3() {
        String[] words = {"abcdef"};
        String target = "xyz";
        int expected = -1;
        Assertions.assertEquals(expected, solution3292.minValidStrings(words, target));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-ii/submissions/565542162/
        // 801 / 807 个通过的测试用例 TLE
        final String fileName = "solution3292-example4-input.txt";
        String[] words = UtUtils.loadingStrings(fileName, 0);
        String target = UtUtils.loadingString(fileName, 1);
        int expected = 3;
        Assertions.assertEquals(expected, solution3292.minValidStrings(words, target));
    }
}