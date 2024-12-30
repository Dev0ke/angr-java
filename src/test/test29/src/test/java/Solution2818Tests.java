import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2818Tests {
    private final Solution2818 solution2818 = new Solution2818();

    @Test
    public void example1() {
        List<Integer> nums = List.of(8, 3, 9, 3, 8);
        int k = 2;
        int expected = 81;
        Assertions.assertEquals(expected, solution2818.maximumScore(nums, k));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(19, 12, 14, 6, 10, 18);
        int k = 3;
        int expected = 4788;
        Assertions.assertEquals(expected, solution2818.maximumScore(nums, k));
    }
}