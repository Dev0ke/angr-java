import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2656Tests {
    private final Solution2656 solution2656 = new Solution2656();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        int expected = 18;
        Assertions.assertEquals(expected, solution2656.maximizeSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5};
        int k = 2;
        int expected = 11;
        Assertions.assertEquals(expected, solution2656.maximizeSum(nums, k));
    }
}