import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2763Tests {
    private final Solution2763 solution2763 = new Solution2763();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution2763.sumImbalanceNumbers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 3, 3, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution2763.sumImbalanceNumbers(nums));
    }
}