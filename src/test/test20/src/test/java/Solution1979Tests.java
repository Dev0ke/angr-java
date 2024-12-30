import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1979Tests {
    private final Solution1979 solution1979 = new Solution1979();

    @Test
    public void example1() {
        int[] nums = {2, 5, 6, 9, 10};
        int expected = 2;
        Assertions.assertEquals(expected, solution1979.findGCD(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 5, 6, 8, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution1979.findGCD(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution1979.findGCD(nums));
    }
}
