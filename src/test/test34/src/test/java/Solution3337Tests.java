import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3337Tests {
    private final Solution3337 solution3337 = new Solution3337();

    @Test
    public void example1() {
        String s = "abcyy";
        int t = 2;
        List<Integer> nums = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2);
        int expected = 7;
        Assertions.assertEquals(expected, solution3337.lengthAfterTransformations(s, t, nums));
    }

    @Test
    public void example2() {
        String s = "azbk";
        int t = 1;
        List<Integer> nums = List.of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        int expected = 8;
        Assertions.assertEquals(expected, solution3337.lengthAfterTransformations(s, t, nums));
    }
}