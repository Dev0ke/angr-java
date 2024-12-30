import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1786Tests {
    private final Solution1786 solution1786 = new Solution1786();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1786.countRestrictedPaths(n, edges));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1786.countRestrictedPaths(n, edges));
    }
}
