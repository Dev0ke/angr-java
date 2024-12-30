import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution136Tests {
    private final Solution136 solution136 = new Solution136();

    @Test
    public void example1() {
        int[] nums = {2, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution136.singleNumber(nums));
        Assertions.assertEquals(expected, solution136.singleNumber2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 2, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution136.singleNumber(nums));
        Assertions.assertEquals(expected, solution136.singleNumber2(nums));
    }
}
