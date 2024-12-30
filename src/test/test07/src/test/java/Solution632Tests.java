import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution632Tests {
    private final Solution632 solution632 = new Solution632();

    @Test
    public void example1() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]");
        int[] expected = {20, 24};
        Assertions.assertArrayEquals(expected, solution632.smallestRange(nums));
    }

    @Test
    public void example2() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[1,2,3],[1,2,3],[1,2,3]]");
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution632.smallestRange(nums));
    }
}
