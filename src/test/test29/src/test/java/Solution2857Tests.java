import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2857Tests {
    private final Solution2857 solution2857 = new Solution2857();

    @Test
    public void example1() {
        List<List<Integer>> coordinates = UtUtils.stringToIntegerList2("[[1,2],[4,2],[1,3],[5,2]]");
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution2857.countPairs(coordinates, k));
    }

    @Test
    public void example2() {
        List<List<Integer>> coordinates = UtUtils.stringToIntegerList2("[[1,3],[1,3],[1,3],[1,3],[1,3]]");
        int k = 0;
        int expected = 10;
        Assertions.assertEquals(expected, solution2857.countPairs(coordinates, k));
    }
}