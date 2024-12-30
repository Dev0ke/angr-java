import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1403Tests {
    private final Solution1403 solution1403 = new Solution1403();

    @Test
    public void example1() {
        int[] nums = {4, 3, 10, 9, 8};
        List<Integer> expected = List.of(10, 9);
        Assertions.assertEquals(expected, solution1403.minSubsequence(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 7, 6, 7};
        List<Integer> expected = List.of(7, 7, 6);
        Assertions.assertEquals(expected, solution1403.minSubsequence(nums));
    }

    @Test
    public void example3() {
        int[] nums = {6};
        List<Integer> expected = List.of(6);
        Assertions.assertEquals(expected, solution1403.minSubsequence(nums));
    }
}
