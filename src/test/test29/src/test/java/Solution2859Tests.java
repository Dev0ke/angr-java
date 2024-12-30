import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2859Tests {
    private final Solution2859 solution2859 = new Solution2859();

    @Test
    public void example1() {
        List<Integer> nums = List.of(5, 10, 1, 5, 2);
        int k = 1;
        int expected = 13;
        Assertions.assertEquals(expected, solution2859.sumIndicesWithKSetBits(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(4, 3, 2, 1);
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2859.sumIndicesWithKSetBits(nums, k));
    }
}