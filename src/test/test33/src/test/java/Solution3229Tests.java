import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3229Tests {
    private final Solution3229 solution3229 = new Solution3229();

    @Test
    public void example1() {
        int[] nums = {3, 5, 1, 2};
        int[] target = {4, 6, 2, 4};
        long expected = 2;
        Assertions.assertEquals(expected, solution3229.minimumOperations(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 2};
        int[] target = {2, 1, 4};
        long expected = 5;
        Assertions.assertEquals(expected, solution3229.minimumOperations(nums, target));
    }
}