import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2826Tests {
    private final Solution2826 solution2826 = new Solution2826();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 1, 3, 2, 1);
        int expected = 3;
        Assertions.assertEquals(expected, solution2826.minimumOperations(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(1, 3, 2, 1, 3, 3);
        int expected = 2;
        Assertions.assertEquals(expected, solution2826.minimumOperations(nums));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(2, 2, 2, 2, 3, 3);
        int expected = 0;
        Assertions.assertEquals(expected, solution2826.minimumOperations(nums));
    }
}