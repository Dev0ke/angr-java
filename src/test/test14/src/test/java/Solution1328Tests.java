import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1328Tests {
    private final Solution1328 solution1328 = new Solution1328();

    @Test
    public void example1() {
        String palindrome = "abccba";
        String expected = "aaccba";
        Assertions.assertEquals(expected, solution1328.breakPalindrome(palindrome));
    }

    @Test
    public void example2() {
        String palindrome = "a";
        String expected = "";
        Assertions.assertEquals(expected, solution1328.breakPalindrome(palindrome));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/break-a-palindrome/submissions/546001232/
        String palindrome = "aba";
        String expected = "abb";
        Assertions.assertEquals(expected, solution1328.breakPalindrome(palindrome));
    }
}