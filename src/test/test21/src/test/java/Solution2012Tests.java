import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2012Tests {
    private final Solution2012 solution2012 = new Solution2012();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2012.sumOfBeauties(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 6, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution2012.sumOfBeauties(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2012.sumOfBeauties(nums));
    }
}
