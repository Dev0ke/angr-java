import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2809Tests {
    private final Solution2809 solution2809 = new Solution2809();

    @Test
    public void example1() {
        List<Integer> nums1 = List.of(1, 2, 3);
        List<Integer> nums2 = List.of(1, 2, 3);
        int x = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution2809.minimumTime(nums1, nums2, x));
    }

    @Test
    public void example2() {
        List<Integer> nums1 = List.of(1, 2, 3);
        List<Integer> nums2 = List.of(3, 3, 3);
        int x = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution2809.minimumTime(nums1, nums2, x));
    }
}