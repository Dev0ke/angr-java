import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution201Tests {
    private final Solution201 solution201 = new Solution201();

    @Test
    public void example1() {
        int left = 5;
        int right = 7;
        int expected = 4;
        Assertions.assertEquals(expected, solution201.rangeBitwiseAnd(left, right));
    }

    @Test
    public void example2() {
        int left = 0;
        int right = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution201.rangeBitwiseAnd(left, right));
    }

    @Test
    public void example3() {
        int left = 1;
        int right = 2147483647;
        int expected = 0;
        Assertions.assertEquals(expected, solution201.rangeBitwiseAnd(left, right));
    }
}
