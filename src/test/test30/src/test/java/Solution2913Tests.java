import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2913Tests {
    private final Solution2913 solution2913 = new Solution2913();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 1);
        int expected = 15;
        Assertions.assertEquals(expected, solution2913.sumCounts(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 2);
        int expected = 3;
        Assertions.assertEquals(expected, solution2913.sumCounts(nums));
    }
}