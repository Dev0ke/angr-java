import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1675Tests {
    private final Solution1675 solution1675 = new Solution1675();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution1675.minimumDeviation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 5, 20, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution1675.minimumDeviation(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 10, 8};
        int expected = 3;
        Assertions.assertEquals(expected, solution1675.minimumDeviation(nums));
    }
}