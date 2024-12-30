import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1748Tests {
    private final Solution1748 solution1748 = new Solution1748();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution1748.sumOfUnique(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1748.sumOfUnique(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 15;
        Assertions.assertEquals(expected, solution1748.sumOfUnique(nums));
    }
}
