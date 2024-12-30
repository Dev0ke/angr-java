import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3260Tests {
    private final Solution3260.V1 solution3260_v1 = new Solution3260.V1();
    private final Solution3260.V2 solution3260_v2 = new Solution3260.V2();

    @Test
    public void example1() {
        int n = 3;
        int k = 5;
        String expected = "595";
        Assertions.assertEquals(expected, solution3260_v1.largestPalindrome(n, k));
        Assertions.assertEquals(expected, solution3260_v2.largestPalindrome(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 4;
        String expected = "8";
        Assertions.assertEquals(expected, solution3260_v1.largestPalindrome(n, k));
        Assertions.assertEquals(expected, solution3260_v2.largestPalindrome(n, k));
    }

    @Test
    public void example3() {
        int n = 5;
        int k = 6;
        String expected = "89898";
        Assertions.assertEquals(expected, solution3260_v1.largestPalindrome(n, k));
        Assertions.assertEquals(expected, solution3260_v2.largestPalindrome(n, k));
    }
}