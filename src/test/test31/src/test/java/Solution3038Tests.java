import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3038Tests {
    private final Solution3038 solution3038 = new Solution3038();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1, 4, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3038.maxOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 6, 1, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3038.maxOperations(nums));
    }
}