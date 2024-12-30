import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1018Tests {
    private final Solution1018 solution1018 = new Solution1018();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1};
        List<Boolean> expected = List.of(true, false, false);
        Assertions.assertEquals(expected, solution1018.prefixesDivBy5(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        List<Boolean> expected = List.of(false, false, false);
        Assertions.assertEquals(expected, solution1018.prefixesDivBy5(nums));
    }
}