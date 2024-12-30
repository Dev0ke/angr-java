import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2575Tests {
    private final Solution2575 solution2575 = new Solution2575();

    @Test
    public void example1() {
        String word = "998244353";
        int m = 3;
        int[] expected = {1, 1, 0, 0, 0, 1, 1, 0, 0};
        Assertions.assertArrayEquals(expected, solution2575.divisibilityArray(word, m));
    }

    @Test
    public void example2() {
        String word = "1010";
        int m = 10;
        int[] expected = {0, 1, 0, 1};
        Assertions.assertArrayEquals(expected, solution2575.divisibilityArray(word, m));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/406285082/
        // 爆 long
        String word = "91221181269244172125025075166510211202115152121212341281327";
        int m = 21;
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        Assertions.assertArrayEquals(expected, solution2575.divisibilityArray(word, m));
    }
}