import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1332Tests {
    private final Solution1332 solution1332 = new Solution1332();

    @Test
    public void example1() {
        String s = "ababa";
        int expected = 1;
        Assertions.assertEquals(expected, solution1332.removePalindromeSub(s));
    }

    @Test
    public void example2() {
        String s = "abb";
        int expected = 2;
        Assertions.assertEquals(expected, solution1332.removePalindromeSub(s));
    }

    @Test
    public void example3() {
        String s = "baabb";
        int expected = 2;
        Assertions.assertEquals(expected, solution1332.removePalindromeSub(s));
    }
}
