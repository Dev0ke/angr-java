import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1882Tests {
    private final Solution1882 solution1882 = new Solution1882();

    @Test
    public void example1() {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] expected = {2, 2, 0, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution1882.assignTasks(servers, tasks));
    }

    @Test
    public void example2() {
        int[] servers = {5, 1, 4, 3, 2};
        int[] tasks = {2, 1, 2, 4, 5, 2, 1};
        int[] expected = {1, 4, 1, 4, 1, 3, 2};
        Assertions.assertArrayEquals(expected, solution1882.assignTasks(servers, tasks));
    }
}