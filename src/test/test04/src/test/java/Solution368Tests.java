import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution368Tests {
    private final Solution368 solution368 = new Solution368();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        // [1,3] 也会被视为正确答案。
        List<Integer> expected = List.of(1, 2);
        List<Integer> actual = solution368.largestDivisibleSubset(nums);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> expected = List.of(1, 2, 4, 8);
        List<Integer> actual = solution368.largestDivisibleSubset(nums);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}