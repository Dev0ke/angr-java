import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3067Tests {
    private final Solution3067 solution3067 = new Solution3067();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,5],[2,3,13],[3,4,9],[4,5,2]]");
        int signalSpeed = 1;
        int[] expected = {0, 4, 6, 6, 4, 0};
        Assertions.assertArrayEquals(expected, solution3067.countPairsOfConnectableServers(edges, signalSpeed));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,6,3],[6,5,3],[0,3,1],[3,2,7],[3,1,6],[3,4,2]]");
        int signalSpeed = 3;
        int[] expected = {2, 0, 0, 0, 0, 0, 2};
        Assertions.assertArrayEquals(expected, solution3067.countPairsOfConnectableServers(edges, signalSpeed));
    }
}