import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1200Tests {
    private final Solution1200 solution1200 = new Solution1200();

    @Test
    public void example1() {
        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2],[2,3],[3,4]]");
        Assertions.assertEquals(expected, solution1200.minimumAbsDifference(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 3, 6, 10, 15};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3]]");
        Assertions.assertEquals(expected, solution1200.minimumAbsDifference(arr));
    }

    @Test
    public void example3() {
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[-14,-10],[19,23],[23,27]]");
        Assertions.assertEquals(expected, solution1200.minimumAbsDifference(arr));
    }
}
