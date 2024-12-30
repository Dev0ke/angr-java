import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2602Tests {
    private final Solution2602 solution2602 = new Solution2602();

    @Test
    public void example1() {
        int[] nums = {3, 1, 6, 8};
        int[] queries = {1, 5};
        List<Long> expected = Arrays.asList(14L, 10L);
        Assertions.assertEquals(expected, solution2602.minOperations(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 9, 6, 3};
        int[] queries = {10};
        List<Long> expected = Arrays.asList(20L);
        Assertions.assertEquals(expected, solution2602.minOperations(nums, queries));
    }
}