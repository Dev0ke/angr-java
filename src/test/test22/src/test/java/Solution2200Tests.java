import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2200Tests {
    private final Solution2200 solution2200 = new Solution2200();

    @Test
    public void example1() {
        int[] nums = {3, 4, 9, 1, 3, 9, 5};
        int key = 9;
        int k = 1;
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertEquals(expected, solution2200.findKDistantIndices(nums, key, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int key = 2;
        int k = 2;
        List<Integer> expected = List.of(0, 1, 2, 3, 4);
        Assertions.assertEquals(expected, solution2200.findKDistantIndices(nums, key, k));
    }
}
