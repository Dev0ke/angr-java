import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1489Tests {
    private final Solution1489.V1 solution1489_v1 = new Solution1489.V1();
    private final Solution1489.V2 solution1489_v2 = new Solution1489.V2();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[2,3,4,5]]");
        Assertions.assertEquals(expected, solution1489_v1.findCriticalAndPseudoCriticalEdges(n, edges));
//        Assertions.assertEquals(expected, solution1489_v2.findCriticalAndPseudoCriticalEdges(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[2,3,1],[0,3,1]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[],[0,1,2,3]]");
        Assertions.assertEquals(expected, solution1489_v1.findCriticalAndPseudoCriticalEdges(n, edges));
        Assertions.assertEquals(expected, solution1489_v2.findCriticalAndPseudoCriticalEdges(n, edges));
    }
}
