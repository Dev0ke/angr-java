import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2766Tests {
    private final Solution2766 solution2766 = new Solution2766();

    @Test
    public void example1() {
        int[] nums = {1, 6, 7, 8};
        int[] moveFrom = {1, 7, 2};
        int[] moveTo = {2, 9, 5};
        List<Integer> expected = List.of(5, 6, 8, 9);
        Assertions.assertEquals(expected, solution2766.relocateMarbles(nums, moveFrom, moveTo));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 3, 3};
        int[] moveFrom = {1, 3};
        int[] moveTo = {2, 2};
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, solution2766.relocateMarbles(nums, moveFrom, moveTo));
    }
}