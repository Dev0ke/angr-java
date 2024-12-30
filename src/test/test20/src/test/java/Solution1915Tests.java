import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1915Tests {
    private final Solution1915 solution1915 = new Solution1915();

    @Test
    public void example1() {
        String word = "aba";
        long expected = 4;
        Assertions.assertEquals(expected, solution1915.wonderfulSubstrings(word));
    }

    @Test
    public void example2() {
        String word = "aabb";
        long expected = 9;
        Assertions.assertEquals(expected, solution1915.wonderfulSubstrings(word));
    }

    @Test
    public void example3() {
        String word = "he";
        long expected = 2;
        Assertions.assertEquals(expected, solution1915.wonderfulSubstrings(word));
    }
}
