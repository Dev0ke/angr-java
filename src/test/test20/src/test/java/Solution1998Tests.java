import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1998Tests {
    private final Solution1998 solution1998 = new Solution1998();

    @Test
    public void example1() {
        int[] nums = {7, 21, 3};
        Assertions.assertTrue(solution1998.gcdSort(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 2, 6, 2};
        Assertions.assertFalse(solution1998.gcdSort(nums));
    }

    @Test
    public void example3() {
        int[] nums = {10, 5, 9, 3, 15};
        Assertions.assertTrue(solution1998.gcdSort(nums));
    }
}
