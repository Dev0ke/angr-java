import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1409Tests {
    private final Solution1409 solution1409 = new Solution1409();

    @Test
    public void example1() {
        int[] queries = {3, 1, 2, 1};
        int m = 5;
        int[] expected = {2, 1, 2, 1};
        Assertions.assertArrayEquals(expected, solution1409.processQueries(queries, m));
    }

    @Test
    public void example2() {
        int[] queries = {4, 1, 2, 2};
        int m = 4;
        int[] expected = {3, 1, 2, 0};
        Assertions.assertArrayEquals(expected, solution1409.processQueries(queries, m));
    }

    @Test
    public void example3() {
        int[] queries = {7, 5, 5, 8, 3};
        int m = 8;
        int[] expected = {6, 5, 0, 7, 5};
        Assertions.assertArrayEquals(expected, solution1409.processQueries(queries, m));
    }
}