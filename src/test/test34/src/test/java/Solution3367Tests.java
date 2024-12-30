import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3367Tests {
    private final Solution3367 solution3367 = new Solution3367();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,4],[0,2,2],[2,3,12],[2,4,6]]");
        int k = 2;
        long expected = 22;
        Assertions.assertEquals(expected, solution3367.maximizeSumOfWeights(edges, k));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,5],[1,2,10],[0,3,15],[3,4,20],[3,5,5],[0,6,10]]");
        int k = 3;
        long expected = 65;
        Assertions.assertEquals(expected, solution3367.maximizeSumOfWeights(edges, k));
    }
}