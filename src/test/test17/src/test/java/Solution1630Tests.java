import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1630Tests {
    private final Solution1630 solution1630 = new Solution1630();

    @Test
    public void example1() {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        List<Boolean> expected = List.of(true, false, true);
        Assertions.assertEquals(expected, solution1630.checkArithmeticSubarrays(nums, l, r));
    }

    @Test
    public void example2() {
        int[] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
        int[] l = {0, 1, 6, 4, 8, 7};
        int[] r = {4, 4, 9, 7, 9, 10};
        List<Boolean> expected = List.of(false, true, false, false, true, true);
        Assertions.assertEquals(expected, solution1630.checkArithmeticSubarrays(nums, l, r));
    }
}
