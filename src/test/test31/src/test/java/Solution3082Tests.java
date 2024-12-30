import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3082Tests {
    private final Solution3082.V1 solution3082_v1 = new Solution3082.V1();
    private final Solution3082.V2 solution3082_v2 = new Solution3082.V2();
    private final Solution3082.V3 solution3082_v3 = new Solution3082.V3();
    private final Solution3082.V4 solution3082_v4 = new Solution3082.V4();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution3082_v1.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v2.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v3.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v4.sumOfPower(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 3};
        int k = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution3082_v1.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v2.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v3.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v4.sumOfPower(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int k = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution3082_v1.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v2.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v3.sumOfPower(nums, k));
        Assertions.assertEquals(expected, solution3082_v4.sumOfPower(nums, k));
    }
}