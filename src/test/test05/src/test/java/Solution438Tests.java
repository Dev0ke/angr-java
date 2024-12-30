import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution438Tests {
    private final Solution438 solution438 = new Solution438();

    @Test
    public void example1() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> expected = List.of(0, 6);
        Assertions.assertEquals(expected, solution438.findAnagrams(s, p));
    }

    @Test
    public void example2() {
        String s = "abab";
        String p = "ab";
        List<Integer> expected = List.of(0, 1, 2);
        Assertions.assertEquals(expected, solution438.findAnagrams(s, p));
    }
}
