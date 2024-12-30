import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution410Tests {
    private final Solution410 solution410 = new Solution410();

    @Test
    public void example1() {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int expected = 18;
        Assertions.assertEquals(expected, solution410.splitArray(nums, m));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        int expected = 9;
        Assertions.assertEquals(expected, solution410.splitArray(nums, m));
    }

    @Test
    public void example3() {
        int[] nums = {1, 4, 4};
        int m = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution410.splitArray(nums, m));
    }
}
