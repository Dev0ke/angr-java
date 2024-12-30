import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1869Tests {
    private final Solution1869 solution1869 = new Solution1869();

    @Test
    public void example1() {
        String s = "1101";
        Assertions.assertTrue(solution1869.checkZeroOnes(s));
    }

    @Test
    public void example2() {
        String s = "111000";
        Assertions.assertFalse(solution1869.checkZeroOnes(s));
    }

    @Test
    public void example3() {
        String s = "110100010";
        Assertions.assertFalse(solution1869.checkZeroOnes(s));
    }
}
