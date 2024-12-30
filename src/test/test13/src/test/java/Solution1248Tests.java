import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1248Tests {
    private final Solution1248 solution1248 = new Solution1248();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1248.numberOfSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 6};
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution1248.numberOfSubarrays(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        int expected = 16;
        Assertions.assertEquals(expected, solution1248.numberOfSubarrays(nums, k));
    }
}
