import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2155Tests {
    private final Solution2155 solution2155 = new Solution2155();

    @Test
    public void example1() {
        int[] nums = {0, 0, 1, 0};
        List<Integer> expected = Arrays.asList(2, 4);
        List<Integer> actual = solution2155.maxScoreIndices(nums);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0};
        List<Integer> expected = Arrays.asList(3);
        List<Integer> actual = solution2155.maxScoreIndices(nums);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] nums = {1, 1};
        List<Integer> expected = Arrays.asList(0);
        List<Integer> actual = solution2155.maxScoreIndices(nums);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
