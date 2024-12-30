import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution229Tests {
    private final Solution229 solution229 = new Solution229();

    @Test
    public void example1() {
        int[] nums = {3, 2, 3};
        List<Integer> expected = List.of(3);
        Assertions.assertEquals(expected, solution229.majorityElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution229.majorityElement(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution229.majorityElement(nums));
    }
}
