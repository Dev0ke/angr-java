import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1961Tests {
    private final Solution1961 solution1961 = new Solution1961();

    @Test
    public void example1() {
        String s = "iloveleetcode";
        String[] words = {"i", "love", "leetcode", "apples"};
        Assertions.assertTrue(solution1961.isPrefixString(s, words));
    }

    @Test
    public void example2() {
        String s = "iloveleetcode";
        String[] words = {"apples", "i", "love", "leetcode"};
        Assertions.assertFalse(solution1961.isPrefixString(s, words));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "a";
        String[] words = {"aa", "aaaa", "banana"};
        Assertions.assertFalse(solution1961.isPrefixString(s, words));
    }

    @Test
    public void example4() {
        String s = "ccccccccc";
        String[] words = {"c", "cc"};
        Assertions.assertFalse(solution1961.isPrefixString(s, words));
    }
}
