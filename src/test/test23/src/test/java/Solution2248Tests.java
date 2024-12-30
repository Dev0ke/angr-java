import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2248Tests {
    private final Solution2248 solution2248 = new Solution2248();

    @Test
    public void example1() {
        int[][] nums = UtUtils.stringToInts2("[[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]");
        List<Integer> expected = List.of(3, 4);
        Assertions.assertEquals(expected, solution2248.intersection(nums));
    }

    @Test
    public void example2() {
        int[][] nums = UtUtils.stringToInts2("[[1,2,3],[4,5,6]]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution2248.intersection(nums));
    }
}
