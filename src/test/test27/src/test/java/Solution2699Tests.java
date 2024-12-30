import org.junit.jupiter.api.Test;

public class Solution2699Tests {
    private final Solution2699 solution2699 = new Solution2699();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]");
        int source = 0;
        int destination = 1;
        int target = 5;
        int[][] actual = solution2699.modifiedGraphEdges(n, edges, source, destination, target);
        // TODO
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,-1],[0,2,5]]");
        int source = 0;
        int destination = 2;
        int target = 6;
        int[][] actual = solution2699.modifiedGraphEdges(n, edges, source, destination, target);
        // TODO
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[1,0,4],[1,2,3],[2,3,5],[0,3,-1]]");
        int source = 0;
        int destination = 2;
        int target = 6;
        int[][] actual = solution2699.modifiedGraphEdges(n, edges, source, destination, target);
        // TODO
    }
}