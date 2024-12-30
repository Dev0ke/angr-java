import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2845Tests {
    private final Solution2845 solution2845 = new Solution2845();

    @Test
    public void example1() {
        List<Integer> nums = List.of(3, 2, 4);
        int modulo = 2;
        int k = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution2845.countInterestingSubarrays(nums, modulo, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(3, 1, 9, 6);
        int modulo = 3;
        int k = 0;
        long expected = 2;
        Assertions.assertEquals(expected, solution2845.countInterestingSubarrays(nums, modulo, k));
    }
}