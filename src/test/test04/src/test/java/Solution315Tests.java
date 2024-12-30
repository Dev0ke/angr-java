import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution315Tests {
    private final Solution315 solution315 = new Solution315();

    @Test
    public void example1() {
        int[] nums = {5, 2, 6, 1};
        List<Integer> expected = List.of(2, 1, 1, 0);
        Assertions.assertEquals(expected, solution315.countSmaller(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1};
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution315.countSmaller(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, -1};
        List<Integer> expected = List.of(0, 0);
        Assertions.assertEquals(expected, solution315.countSmaller(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = UtUtils.loadingInts("solution315-example4-input.txt", 0);
        List<Integer> expected = UtUtils.loadingIntegerList("solution315-example4-output.txt", 0);
        Assertions.assertEquals(expected, solution315.countSmaller(nums));
    }
}
