import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2530Tests {
    private final Solution2530 solution2530 = new Solution2530();

    @Test
    public void example1() {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        long expected = 50;
        Assertions.assertEquals(expected, solution2530.maxKelements(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        long expected = 17;
        Assertions.assertEquals(expected, solution2530.maxKelements(nums, k));
    }
}
