import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1838Tests {
    private final Solution1838 solution1838 = new Solution1838();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4};
        int k = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solution1838.maxFrequency(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 8, 13};
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1838.maxFrequency(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 9, 6};
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1838.maxFrequency(nums, k));
    }
}
