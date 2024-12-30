import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2294Tests {
    private final Solution2294 solution2294 = new Solution2294();

    @Test
    public void example1() {
        int[] nums = {3, 6, 1, 2, 5};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2294.partitionArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2294.partitionArray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 4, 5};
        int k = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution2294.partitionArray(nums, k));
    }
}
