import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution442Tests {
    private final Solution442 solution442 = new Solution442();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = List.of(2, 3);
        Assertions.assertEquals(expected, solution442.findDuplicates(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2};
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution442.findDuplicates(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution442.findDuplicates(nums));
    }
}
