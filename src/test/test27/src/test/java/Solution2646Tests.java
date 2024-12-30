import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2646Tests {
    private final Solution2646 solution2646 = new Solution2646();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3]]");
        int[] price = {2, 2, 10, 6};
        int[][] trips = UtUtils.stringToInts2("[[0,3],[2,1],[2,3]]");
        int expected = 23;
        Assertions.assertEquals(expected, solution2646.minimumTotalPrice(n, edges, price, trips));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int[] price = {2, 2};
        int[][] trips = UtUtils.stringToInts2("[[0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2646.minimumTotalPrice(n, edges, price, trips));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/424958742/
        // TLE
        int n = 50;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,9],[9,10],[10,11],[11,12],[12,13],[13,14],[14,15],[15,16],[16,17],[17,18],[18,19],[19,20],[20,21],[21,22],[22,23],[23,24],[24,25],[25,26],[26,27],[27,28],[28,29],[29,30],[30,31],[31,32],[32,33],[33,34],[34,35],[35,36],[36,37],[37,38],[38,39],[39,40],[40,41],[41,42],[42,43],[43,44],[44,45],[45,46],[46,47],[47,48],[48,49]]");
        int[] price = {2, 820, 460, 262, 598, 192, 758, 922, 266, 628, 74, 720, 614, 304, 716, 764, 110, 328, 344, 160, 884, 80, 154, 424, 858, 466, 602, 114, 432, 140, 726, 438, 774, 346, 944, 596, 974, 552, 536, 564, 938, 888, 376, 980, 502, 196, 80, 870, 1000, 998};
        int[][] trips = UtUtils.stringToInts2("[[9,9]]");
        int expected = 314;
        Assertions.assertEquals(expected, solution2646.minimumTotalPrice(n, edges, price, trips));
        Assertions.assertEquals(expected, solution2646.minimumTotalPrice2(n, edges, price, trips));
    }
}