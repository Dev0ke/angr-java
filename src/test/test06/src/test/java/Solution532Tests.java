import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution532Tests {
    private final Solution532 solution532 = new Solution532();

    @Test
    public void example1() {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution532.findPairs(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution532.findPairs(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 1, 5, 4};
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution532.findPairs(nums, k));
    }
}