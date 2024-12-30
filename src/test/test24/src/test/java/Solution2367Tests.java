import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2367Tests {
    private final Solution2367 solution2367 = new Solution2367();

    @Test
    public void example1() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution2367.arithmeticTriplets(nums, diff));
        Assertions.assertEquals(expected, solution2367.arithmeticTriplets2(nums, diff));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution2367.arithmeticTriplets(nums, diff));
        Assertions.assertEquals(expected, solution2367.arithmeticTriplets2(nums, diff));
    }
}
