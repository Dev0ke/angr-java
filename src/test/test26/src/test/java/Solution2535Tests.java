import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2535Tests {
    private final Solution2535 solution2535 = new Solution2535();

    @Test
    public void example1() {
        int[] nums = {1, 15, 6, 3};
        int expected = 9;
        Assertions.assertEquals(expected, solution2535.differenceOfSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution2535.differenceOfSum(nums));
    }
}
