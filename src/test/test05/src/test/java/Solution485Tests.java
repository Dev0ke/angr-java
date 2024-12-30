import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution485Tests {
    private final Solution485 solution485 = new Solution485();

    @Test
    public void example1() {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution485.findMaxConsecutiveOnes(nums));
    }
}
