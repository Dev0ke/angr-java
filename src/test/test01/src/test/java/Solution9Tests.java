import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution9Tests {
    private final Solution9 solution9 = new Solution9();

    @Test
    public void example1() {
        int x = 121;
        Assertions.assertTrue(solution9.isPalindrome(x));
    }

    @Test
    public void example2() {
        int x = -121;
        Assertions.assertFalse(solution9.isPalindrome(x));
    }

    @Test
    public void example3() {
        int x = 10;
        Assertions.assertFalse(solution9.isPalindrome(x));
    }

    @Test
    public void example4() {
        int x = -101;
        Assertions.assertFalse(solution9.isPalindrome(x));
    }
}
