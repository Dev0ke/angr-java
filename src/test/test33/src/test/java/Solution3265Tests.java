import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3265Tests {
    private final Solution3265.V1 solution3265_v1 = new Solution3265.V1();
    private final Solution3265.V2 solution3265_v2 = new Solution3265.V2();

    @Test
    public void example1() {
        int[] nums = {3, 12, 30, 17, 21};
        int expected = 2;
        Assertions.assertEquals(expected, solution3265_v1.countPairs(nums));
        Assertions.assertEquals(expected, solution3265_v2.countPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 10;
        Assertions.assertEquals(expected, solution3265_v1.countPairs(nums));
        Assertions.assertEquals(expected, solution3265_v2.countPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {123, 231};
        int expected = 0;
        Assertions.assertEquals(expected, solution3265_v1.countPairs(nums));
        Assertions.assertEquals(expected, solution3265_v2.countPairs(nums));
    }
}