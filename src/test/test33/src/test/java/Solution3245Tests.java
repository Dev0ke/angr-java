import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3245Tests {
    private final Solution3245 solution3245 = new Solution3245();

    @Test
    public void example1() {
        int[] colors = {0, 1, 1, 0, 1};
        int[][] queries = UtUtils.stringToInts2("[[2,1,0],[1,4]]");
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, solution3245.numberOfAlternatingGroups(colors, queries));
    }

    @Test
    public void example2() {
        int[] colors = {0, 0, 1, 0, 1, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,3],[2,3,0],[1,5]]");
        List<Integer> expected = List.of(2, 0);
        Assertions.assertEquals(expected, solution3245.numberOfAlternatingGroups(colors, queries));
    }
}