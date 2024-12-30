import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1671Tests {
    private final Solution1671 solution1671 = new Solution1671();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1671.minimumMountainRemovals(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1671.minimumMountainRemovals(nums));
    }
}
