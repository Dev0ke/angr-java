import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1512Tests {
    private final Solution1512 solution1512 = new Solution1512();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution1512.numIdenticalPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution1512.numIdenticalPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1512.numIdenticalPairs(nums));
    }
}