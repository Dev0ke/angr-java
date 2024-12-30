import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2780Tests {
    private final Solution2780 solution2780 = new Solution2780();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 2, 2);
        int expected = 2;
        Assertions.assertEquals(expected, solution2780.minimumIndex(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1);
        int expected = 4;
        Assertions.assertEquals(expected, solution2780.minimumIndex(nums));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(3, 3, 3, 3, 7, 2, 2);
        int expected = -1;
        Assertions.assertEquals(expected, solution2780.minimumIndex(nums));
    }
}