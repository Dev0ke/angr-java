import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution131Tests {
    private final Solution131 solution131 = new Solution131();

    @Test
    public void example1() {
        String s = "aab";
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["a","a","b"],["aa","b"]]
                """);
        Assertions.assertEquals(expected, solution131.partition131(s));
    }

    @Test
    public void example2() {
        String s = "a";
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["a"]]
                """);
        Assertions.assertEquals(expected, solution131.partition131(s));
    }

    // 剑指 Offer II 086. 分割回文子字符串
    // https://leetcode.cn/problems/M99OJA/
    @Test
    public void example1_2() {
        String s = "google";
        String[][] expected = UtUtils.stringToStrings2("""
                [["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
                """);
        Assertions.assertArrayEquals(expected, solution131.partition(s));
    }

    @Test
    public void example2_2() {
        String s = "aab";
        String[][] expected = UtUtils.stringToStrings2("""
                [["a","a","b"],["aa","b"]]
                """);
        Assertions.assertArrayEquals(expected, solution131.partition(s));
    }

    @Test
    public void example3_2() {
        String s = "a";
        String[][] expected = UtUtils.stringToStrings2("""
                [["a"]]
                """);
        Assertions.assertArrayEquals(expected, solution131.partition(s));
    }
}
