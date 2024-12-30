import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2902Tests {
    private final Solution2902 solution2902 = new Solution2902();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 2, 3);
        int l = 6;
        int r = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution2902.countSubMultisets(nums, l, r));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 1, 4, 2, 7);
        int l = 1;
        int r = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solution2902.countSubMultisets(nums, l, r));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 2, 1, 3, 5, 2);
        int l = 3;
        int r = 5;
        int expected = 9;
        Assertions.assertEquals(expected, solution2902.countSubMultisets(nums, l, r));
    }
}