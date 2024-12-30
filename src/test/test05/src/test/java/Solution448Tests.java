import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution448Tests {
    private final Solution448 solution448 = new Solution448();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected = List.of(5, 6);
        Assertions.assertEquals(expected, solution448.findDisappearedNumbers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1};
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, solution448.findDisappearedNumbers(nums));
    }
}
