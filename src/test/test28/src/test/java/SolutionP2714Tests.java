import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2714Tests {
    private final SolutionP2714 solutionP2714 = new SolutionP2714();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,4],[0,2,2],[2,3,6]]");
        int s = 1;
        int d = 3;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2714.shortestPathWithHops(n, edges, s, d, k));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[3,1,9],[3,2,4],[4,0,9],[0,5,6],[3,6,2],[6,0,4],[1,2,4]]");
        int s = 4;
        int d = 1;
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2714.shortestPathWithHops(n, edges, s, d, k));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,4,2],[0,1,3],[0,2,1],[2,1,4],[1,3,4],[3,4,7]]");
        int s = 2;
        int d = 3;
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2714.shortestPathWithHops(n, edges, s, d, k));
    }
}