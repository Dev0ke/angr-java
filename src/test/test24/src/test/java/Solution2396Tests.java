import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2396Tests {
    private final Solution2396 solution2396 = new Solution2396();

    @Test
    public void example1() {
        int n = 9;
        Assertions.assertFalse(solution2396.isStrictlyPalindromic(n));
        Assertions.assertFalse(solution2396.isStrictlyPalindromic2(n));
    }

    @Test
    public void example2() {
        int n = 4;
        Assertions.assertFalse(solution2396.isStrictlyPalindromic(n));
        Assertions.assertFalse(solution2396.isStrictlyPalindromic2(n));
    }
}
