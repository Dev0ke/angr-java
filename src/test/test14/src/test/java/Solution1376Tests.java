import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1376Tests {
    private final Solution1376 solution1376 = new Solution1376();

    @Test
    public void example1() {
        int n = 1;
        int headID = 0;
        int[] manager = {-1};
        int[] informTime = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution1376.numOfMinutes(n, headID, manager, informTime));
    }

    @Test
    public void example2() {
        int n = 6;
        int headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution1376.numOfMinutes(n, headID, manager, informTime));
    }

    @Test
    public void example3() {
        int n = 7;
        int headID = 6;
        int[] manager = {1, 2, 3, 4, 5, 6, -1};
        int[] informTime = {0, 6, 5, 4, 3, 2, 1};
        int expected = 21;
        Assertions.assertEquals(expected, solution1376.numOfMinutes(n, headID, manager, informTime));
    }

    @Test
    public void example4() {
        int n = 15;
        int headID = 0;
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] informTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution1376.numOfMinutes(n, headID, manager, informTime));
    }

    @Test
    public void example5() {
        int n = 4;
        int headID = 2;
        int[] manager = {3, 3, -1, 2};
        int[] informTime = {0, 0, 162, 914};
        int expected = 1076;
        Assertions.assertEquals(expected, solution1376.numOfMinutes(n, headID, manager, informTime));
    }
}
