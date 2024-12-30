import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3249Tests {
    private final Solution3249 solution3249 = new Solution3249();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution3249.countGoodNodes(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution3249.countGoodNodes(edges));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution3249.countGoodNodes(edges));
    }
}