import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1601Tests {
    private final Solution1601 solution1601 = new Solution1601();

    @Test
    public void example1() {
        int n = 5;
        int[][] requests = UtUtils.stringToInts2("[[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1601.maximumRequests(n, requests));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] requests = UtUtils.stringToInts2("[[0,0],[1,2],[2,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1601.maximumRequests(n, requests));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] requests = UtUtils.stringToInts2("[[0,3],[3,1],[1,2],[2,0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1601.maximumRequests(n, requests));
    }
}
