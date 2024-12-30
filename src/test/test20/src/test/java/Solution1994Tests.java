import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1994Tests {
    private final Solution1994 solution1994 = new Solution1994();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution1994.numberOfGoodSubsets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 3, 15};
        int expected = 5;
        Assertions.assertEquals(expected, solution1994.numberOfGoodSubsets(nums));
    }
}
