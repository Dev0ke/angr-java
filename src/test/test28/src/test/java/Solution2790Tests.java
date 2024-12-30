import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2790Tests {
    private final Solution2790 solution2790 = new Solution2790();

    @Test
    public void example1() {
        List<Integer> usageLimits = Arrays.asList(1, 2, 5);
        int expected = 3;
        Assertions.assertEquals(expected, solution2790.maxIncreasingGroups(usageLimits));
        Assertions.assertEquals(expected, solution2790.maxIncreasingGroups2(usageLimits));
    }

    @Test
    public void example2() {
        List<Integer> usageLimits = Arrays.asList(2, 1, 2);
        int expected = 2;
        Assertions.assertEquals(expected, solution2790.maxIncreasingGroups(usageLimits));
        Assertions.assertEquals(expected, solution2790.maxIncreasingGroups2(usageLimits));
    }

    @Test
    public void example3() {
        List<Integer> usageLimits = Arrays.asList(1, 1);
        int expected = 1;
        Assertions.assertEquals(expected, solution2790.maxIncreasingGroups(usageLimits));
        Assertions.assertEquals(expected, solution2790.maxIncreasingGroups2(usageLimits));
    }
}