import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution611Tests {
    private final Solution611 solution611 = new Solution611();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution611.triangleNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution611.triangleNumber(nums));
    }
}
