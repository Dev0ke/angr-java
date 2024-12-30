import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3267Tests {
    private final Solution3267.V1 solution3267_v1 = new Solution3267.V1();
    private final Solution3267.V2 solution3267_v2 = new Solution3267.V2();

    @Test
    public void example1() {
        int[] nums = {1023, 2310, 2130, 213};
        int expected = 4;
        Assertions.assertEquals(expected, solution3267_v1.countPairs(nums));
        Assertions.assertEquals(expected, solution3267_v2.countPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 100};
        int expected = 3;
        Assertions.assertEquals(expected, solution3267_v1.countPairs(nums));
        Assertions.assertEquals(expected, solution3267_v2.countPairs(nums));
    }
}