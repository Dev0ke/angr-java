import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2949Tests {
    private final Solution2949 solution2949 = new Solution2949();

    @Test
    public void example1() {
        String s = "baeyh";
        int k = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solution2949.beautifulSubstrings(s, k));
    }

    @Test
    public void example2() {
        String s = "abba";
        int k = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution2949.beautifulSubstrings(s, k));
    }

    @Test
    public void example3() {
        String s = "bcdf";
        int k = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution2949.beautifulSubstrings(s, k));
    }
}