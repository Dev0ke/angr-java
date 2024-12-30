import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1371Tests {
    private final Solution1371 solution1371 = new Solution1371();

    @Test
    public void example1() {
        String s = "eleetminicoworoep";
        int expected = 13;
        Assertions.assertEquals(expected, solution1371.findTheLongestSubstring(s));
    }

    @Test
    public void example2() {
        String s = "leetcodeisgreat";
        int expected = 5;
        Assertions.assertEquals(expected, solution1371.findTheLongestSubstring(s));
    }

    @Test
    public void example3() {
        String s = "bcbcbc";
        int expected = 6;
        Assertions.assertEquals(expected, solution1371.findTheLongestSubstring(s));
    }
}
