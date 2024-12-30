import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution162Tests {
    private final Solution162 solution162 = new Solution162();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution162.findPeakElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        // 1 或 5
        List<Integer> expectedList = List.of(1, 5);
        Assertions.assertTrue(expectedList.contains(solution162.findPeakElement(nums)));
    }
}
