import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution189Tests {
    private final Solution189 solution189 = new Solution189();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        solution189.rotate(nums, k);
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void example2() {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        int[] expected = {3, 99, -1, -100};
        solution189.rotate(nums, k);
        Assertions.assertArrayEquals(expected, nums);
    }
}
