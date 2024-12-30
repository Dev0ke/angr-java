import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1390Tests {
    private final Solution1390 solution1390 = new Solution1390();

    @Test
    public void example1() {
        int[] nums = {21, 4, 7};
        int expected = 32;
        Assertions.assertEquals(expected, solution1390.sumFourDivisors(nums));
    }

    @Test
    public void example2() {
        int[] nums = {21, 21};
        int expected = 64;
        Assertions.assertEquals(expected, solution1390.sumFourDivisors(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution1390.sumFourDivisors(nums));
    }
}