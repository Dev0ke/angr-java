import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution561Tests {
    private final Solution561 solution561 = new Solution561();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution561.arrayPairSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 2, 6, 5, 1, 2};
        int expected = 9;
        Assertions.assertEquals(expected, solution561.arrayPairSum(nums));
    }
}
