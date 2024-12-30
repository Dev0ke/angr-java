import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2947Tests {
    private final Solution2947 solution2947 = new Solution2947();

    @Test
    public void example1() {
        String s = "baeyh";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2947.beautifulSubstrings(s, k));
    }

    @Test
    public void example2() {
        String s = "abba";
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution2947.beautifulSubstrings(s, k));
    }

    @Test
    public void example3() {
        String s = "bcdf";
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution2947.beautifulSubstrings(s, k));
    }
}