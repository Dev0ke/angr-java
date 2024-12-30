import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution347Tests {
    private final Solution347 solution347 = new Solution347();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] expected = {1, 2};
        int[] actual = solution347.topKFrequent(nums, k);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        int[] actual = solution347.topKFrequent(nums, k);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }
}
