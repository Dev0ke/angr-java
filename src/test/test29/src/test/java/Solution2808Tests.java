import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2808Tests {
    private final Solution2808 solution2808 = new Solution2808();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 1, 2);
        int expected = 1;
        Assertions.assertEquals(expected, solution2808.minimumSeconds(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 1, 3, 3, 2);
        int expected = 2;
        Assertions.assertEquals(expected, solution2808.minimumSeconds(nums));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(5, 5, 5, 5);
        int expected = 0;
        Assertions.assertEquals(expected, solution2808.minimumSeconds(nums));
    }
}