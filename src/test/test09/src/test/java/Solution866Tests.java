import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution866Tests {
    private final Solution866 solution866 = new Solution866();

    @Test
    public void example1() {
        int n = 6;
        int expected = 7;
        Assertions.assertEquals(expected, solution866.primePalindrome(n));
    }

    @Test
    public void example2() {
        int n = 8;
        int expected = 11;
        Assertions.assertEquals(expected, solution866.primePalindrome(n));
    }

    @Test
    public void example3() {
        int n = 13;
        int expected = 101;
        Assertions.assertEquals(expected, solution866.primePalindrome(n));
    }
}
