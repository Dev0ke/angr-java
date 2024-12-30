import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1936Tests {
    private final Solution1936 solution1936 = new Solution1936();

    @Test
    public void example1() {
        int[] rungs = {1, 3, 5, 10};
        int dist = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1936.addRungs(rungs, dist));
    }

    @Test
    public void example2() {
        int[] rungs = {3, 6, 8, 10};
        int dist = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1936.addRungs(rungs, dist));
    }

    @Test
    public void example3() {
        int[] rungs = {3, 4, 6, 7};
        int dist = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1936.addRungs(rungs, dist));
    }

    @Test
    public void example4() {
        int[] rungs = {5};
        int dist = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solution1936.addRungs(rungs, dist));
    }
}
