import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution283Tests {
    private final Solution283 solution283 = new Solution283();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        solution283.moveZeroes(nums);
        Assertions.assertArrayEquals(expected, nums);
    }
}
