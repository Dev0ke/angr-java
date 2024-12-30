import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3309Tests {
    private final Solution3309 solution3309 = new Solution3309();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 30;
        Assertions.assertEquals(expected, solution3309.maxGoodNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 8, 16};
        int expected = 1296;
        Assertions.assertEquals(expected, solution3309.maxGoodNumber(nums));
    }
}