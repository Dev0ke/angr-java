import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution633Tests {
    private final Solution633 solution633 = new Solution633();

    @Test
    public void example1() {
        int c = 5;
        Assertions.assertTrue(solution633.judgeSquareSum(c));
    }

    @Test
    public void example2() {
        int c = 3;
        Assertions.assertFalse(solution633.judgeSquareSum(c));
    }
}
