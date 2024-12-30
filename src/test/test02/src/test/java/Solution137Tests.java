import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution137Tests {
    private final Solution137 solution137 = new Solution137();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution137.singleNumber(nums));
        Assertions.assertEquals(expected, solution137.singleNumber2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int expected = 99;
        Assertions.assertEquals(expected, solution137.singleNumber(nums));
        Assertions.assertEquals(expected, solution137.singleNumber2(nums));
    }
}
