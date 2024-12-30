import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution31Tests {
    private final Solution31 solution31 = new Solution31();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 3, 2};
        solution31.nextPermutation(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1};
        int[] expected = {1, 2, 3};
        solution31.nextPermutation(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 5};
        int[] expected = {1, 5, 1};
        solution31.nextPermutation(nums);
        Assertions.assertArrayEquals(expected, nums);
    }
}
