import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution594Tests {
    private final Solution594 solution594 = new Solution594();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int expected = 5;
        Assertions.assertEquals(expected, solution594.findLHS(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution594.findLHS(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution594.findLHS(nums));
    }
}
