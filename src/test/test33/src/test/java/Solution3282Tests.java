import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3282Tests {
    private final Solution3282 solution3282 = new Solution3282();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 3, 1, 5);
        long expected = 7;
        Assertions.assertEquals(expected, solution3282.findMaximumScore(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(4, 3, 1, 3, 2);
        long expected = 16;
        Assertions.assertEquals(expected, solution3282.findMaximumScore(nums));
    }
}