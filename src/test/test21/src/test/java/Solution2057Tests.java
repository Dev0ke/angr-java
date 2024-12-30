import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2057Tests {
    private final Solution2057 solution2057 = new Solution2057();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution2057.smallestEqual(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2057.smallestEqual(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution2057.smallestEqual(nums));
    }

    @Test
    public void example4() {
        int[] nums = {2, 1, 3, 5, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution2057.smallestEqual(nums));
    }
}
