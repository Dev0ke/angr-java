import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2089Tests {
    private final Solution2089 solution2089 = new Solution2089();

    @Test
    public void example1() {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution2089.targetIndices(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 3;
        List<Integer> expected = List.of(3);
        Assertions.assertEquals(expected, solution2089.targetIndices(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 5;
        List<Integer> expected = List.of(4);
        Assertions.assertEquals(expected, solution2089.targetIndices(nums, target));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 4;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution2089.targetIndices(nums, target));
    }
}
