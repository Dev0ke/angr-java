import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution479Tests {
    private final Solution479 solution479 = new Solution479();

    @Test
    public void example1() {
        int n = 2;
        int expected = 987;
        Assertions.assertEquals(expected, solution479.largestPalindrome(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 9;
        Assertions.assertEquals(expected, solution479.largestPalindrome(n));
    }
}