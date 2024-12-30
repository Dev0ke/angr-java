import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution974Tests {
    private final Solution974 solution974 = new Solution974();

    @Test
    public void example1() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solution974.subarraysDivByK(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5};
        int k = 9;
        int expected = 0;
        Assertions.assertEquals(expected, solution974.subarraysDivByK(nums, k));
    }
}
