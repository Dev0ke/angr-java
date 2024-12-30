import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2150Tests {
    private final Solution2150 solution2150 = new Solution2150();

    @Test
    public void example1() {
        int[] nums = {10, 6, 5, 8};
        List<Integer> expected = Arrays.asList(10, 8);
        List<Integer> actual = solution2150.findLonely(nums);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 5, 3};
        List<Integer> expected = Arrays.asList(1, 5);
        List<Integer> actual = solution2150.findLonely(nums);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
