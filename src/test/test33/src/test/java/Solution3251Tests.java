import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3251Tests {
    private final Solution3251.V1 solution3251_v1 = new Solution3251.V1();
    private final Solution3251.V2 solution3251_v2 = new Solution3251.V2();
    private final Solution3251 solution3251_v3 = new Solution3251();

    @Test
    public void example1() {
        int[] nums = {2, 3, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution3251_v1.countOfPairs(nums));
        Assertions.assertEquals(expected, solution3251_v2.countOfPairs(nums));
        Assertions.assertEquals(expected, solution3251_v3.countOfPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 5};
        int expected = 126;
        Assertions.assertEquals(expected, solution3251_v1.countOfPairs(nums));
        Assertions.assertEquals(expected, solution3251_v2.countOfPairs(nums));
        Assertions.assertEquals(expected, solution3251_v3.countOfPairs(nums));
    }
}