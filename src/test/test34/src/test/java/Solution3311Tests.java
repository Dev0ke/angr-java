import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3311Tests {
    private final Solution3311 solution3311 = new Solution3311();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[2,3]]");
        int[][] expected = UtUtils.stringToInts2("[[3,1],[2,0]]");
        Assertions.assertArrayEquals(expected, solution3311.constructGridLayout(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,3],[2,3],[2,4]]");
        int[][] expected = UtUtils.stringToInts2("[[4,2,3,1,0]]");
//        Assertions.assertArrayEquals(expected, solution3311.constructGridLayout(n, edges));
    }

    @Test
    public void example3() {
        int n = 9;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,4],[0,5],[1,7],[2,3],[2,4],[2,5],[3,6],[4,6],[4,7],[6,8],[7,8]]");
        int[][] expected = UtUtils.stringToInts2("[[8,6,3],[7,4,2],[1,0,5]]");
        Assertions.assertArrayEquals(expected, solution3311.constructGridLayout(n, edges));
    }
}