import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3266Tests {
    private final Solution3266 solution3266 = new Solution3266();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        int[] expected = {8, 4, 6, 5, 6};
        Assertions.assertArrayEquals(expected, solution3266.getFinalState(nums, k, multiplier));
    }

    @Test
    public void example2() {
        int[] nums = {100000, 2000};
        int k = 2;
        int multiplier = 1000000;
        int[] expected = {999999307, 999999993};
        Assertions.assertArrayEquals(expected, solution3266.getFinalState(nums, k, multiplier));
    }
}