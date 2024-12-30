import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1921Tests {
    private final Solution1921 solution1921 = new Solution1921();

    @Test
    public void example1() {
        int[] dist = {1, 3, 4};
        int[] speed = {1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1921.eliminateMaximum(dist, speed));
    }

    @Test
    public void example2() {
        int[] dist = {1, 1, 2, 3};
        int[] speed = {1, 1, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1921.eliminateMaximum(dist, speed));
    }

    @Test
    public void example3() {
        int[] dist = {3, 2, 4};
        int[] speed = {5, 3, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1921.eliminateMaximum(dist, speed));
    }
}
