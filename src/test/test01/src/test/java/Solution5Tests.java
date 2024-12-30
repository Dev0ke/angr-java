import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution5Tests {
    private final Solution5 solution5 = new Solution5();

    @Test
    public void example1() {
        String s = "babad";
        // "aba" 同样是符合题意的答案。
        List<String> expectedList = List.of("bab", "aba");
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome(s)));
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome2(s)));
    }

    @Test
    public void example2() {
        String s = "cbbd";
        List<String> expectedList = List.of("bb");
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome(s)));
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome2(s)));
    }

    @Test
    public void example3() {
        String s = "a";
        List<String> expectedList = List.of("a");
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome(s)));
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome2(s)));
    }

    @Test
    public void example4() {
        String s = "ac";
        // "c" 同样是符合题意的答案。
        List<String> expectedList = List.of("a", "c");
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome(s)));
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome2(s)));
    }

    // 补充用例
    @Test
    public void example5() {
        String s = "bb";
        List<String> expectedList = List.of("bb");
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome(s)));
        Assertions.assertTrue(expectedList.contains(solution5.longestPalindrome2(s)));
    }
}
