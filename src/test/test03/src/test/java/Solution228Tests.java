import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution228Tests {
    private final Solution228 solution228 = new Solution228();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> expected = List.of("0->2", "4->5", "7");
        Assertions.assertEquals(expected, solution228.summaryRanges(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> expected = List.of("0", "2->4", "6", "8->9");
        Assertions.assertEquals(expected, solution228.summaryRanges(nums));
    }
}
