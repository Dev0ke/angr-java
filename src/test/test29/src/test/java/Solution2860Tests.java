import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2860Tests {
    private final Solution2860 solution2860 = new Solution2860();

    @Test
    public void example1() {
        List<Integer> nums = Arrays.asList(1, 1);
        int expected = 2;
        Assertions.assertEquals(expected, solution2860.countWays(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7);
        int expected = 3;
        Assertions.assertEquals(expected, solution2860.countWays(nums));
    }
}