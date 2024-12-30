import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1643Tests {
    private final Solution1643 solution1643 = new Solution1643();

    @Test
    public void example1() {
        int[] destination = {2, 3};
        int k = 1;
        String expected = "HHHVV";
        Assertions.assertEquals(expected, solution1643.kthSmallestPath(destination, k));
    }

    @Test
    public void example2() {
        int[] destination = {2, 3};
        int k = 2;
        String expected = "HHVHV";
        Assertions.assertEquals(expected, solution1643.kthSmallestPath(destination, k));
    }

    @Test
    public void example3() {
        int[] destination = {2, 3};
        int k = 3;
        String expected = "HHVVH";
        Assertions.assertEquals(expected, solution1643.kthSmallestPath(destination, k));
    }
}