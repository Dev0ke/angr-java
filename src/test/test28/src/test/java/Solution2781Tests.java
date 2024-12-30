import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2781Tests {
    private final Solution2781 solution2781 = new Solution2781();

    @Test
    public void example1() {
        String word = "cbaaaabc";
        List<String> forbidden = List.of("aaa", "cb");
        int expected = 4;
        Assertions.assertEquals(expected, solution2781.longestValidSubstring(word, forbidden));
    }

    @Test
    public void example2() {
        String word = "leetcode";
        List<String> forbidden = List.of("de", "le", "e");
        int expected = 4;
        Assertions.assertEquals(expected, solution2781.longestValidSubstring(word, forbidden));
    }
}