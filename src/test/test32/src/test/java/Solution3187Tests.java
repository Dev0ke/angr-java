import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3187Tests {
    private final Solution3187 solution3187 = new Solution3187();

    @Test
    public void example1() {
        int[] nums = {3, 1, 4, 2, 5};
        int[][] queries = UtUtils.stringToInts2("[[2,3,4],[1,0,4]]");
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution3187.countOfPeaks(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 4, 2, 1, 5};
        int[][] queries = UtUtils.stringToInts2("[[2,2,4],[1,0,2],[1,0,4]]");
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected, solution3187.countOfPeaks(nums, queries));
    }
}