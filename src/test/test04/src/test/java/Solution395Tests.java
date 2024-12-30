import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution395Tests {
    private final Solution395.V1 solution395_v1 = new Solution395.V1();
    private final Solution395.V2 solution395_v2 = new Solution395.V2();

    @Test
    public void example1() {
        String s = "aaabb";
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution395_v1.longestSubstring(s, k));
        Assertions.assertEquals(expected, solution395_v2.longestSubstring(s, k));
    }

    @Test
    public void example2() {
        String s = "ababbc";
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution395_v1.longestSubstring(s, k));
        Assertions.assertEquals(expected, solution395_v2.longestSubstring(s, k));
    }
}
