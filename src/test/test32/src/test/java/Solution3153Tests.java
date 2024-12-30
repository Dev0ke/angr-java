import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3153Tests {
    private final Solution3153 solution3153 = new Solution3153();

    @Test
    public void example1() {
        int[] nums = {13, 23, 12};
        long expected = 4;
        Assertions.assertEquals(expected, solution3153.sumDigitDifferences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 10, 10, 10};
        long expected = 0;
        Assertions.assertEquals(expected, solution3153.sumDigitDifferences(nums));
    }
}