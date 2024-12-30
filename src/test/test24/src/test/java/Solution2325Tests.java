import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2325Tests {
    private final Solution2325 solution2325 = new Solution2325();

    @Test
    public void example1() {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String expected = "this is a secret";
        Assertions.assertEquals(expected, solution2325.decodeMessage(key, message));
    }

    @Test
    public void example2() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String expected = "the five boxing wizards jump quickly";
        Assertions.assertEquals(expected, solution2325.decodeMessage(key, message));
    }
}
