import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution75Tests {
    private final Solution75 solution75 = new Solution75();

    @Test
    public void example1() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        solution75.sortColors(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void example2() {
        int[] nums = {2, 0, 1};
        int[] expected = {0, 1, 2};
        solution75.sortColors(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int[] expected = {0};
        solution75.sortColors(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void example4() {
        int[] nums = {1};
        int[] expected = {1};
        solution75.sortColors(nums);
        Assertions.assertArrayEquals(expected, nums);
    }
}
