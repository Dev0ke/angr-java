import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1971Tests {
    private final Solution1971 solution1971 = new Solution1971();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,0]]");
        int source = 0;
        int destination = 2;
        Assertions.assertTrue(solution1971.validPath(n, edges, source, destination));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[3,5],[5,4],[4,3]]");
        int source = 0;
        int destination = 5;
        Assertions.assertFalse(solution1971.validPath(n, edges, source, destination));
    }
}
