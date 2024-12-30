import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1223Tests {
    private final Solution1223 solution1223 = new Solution1223();

    @Test
    public void example1() {
        int n = 2;
        int[] rollMax = {1, 1, 2, 2, 2, 3};
        int expected = 34;
        Assertions.assertEquals(expected, solution1223.dieSimulator(n, rollMax));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] rollMax = {1, 1, 1, 1, 1, 1};
        int expected = 30;
        Assertions.assertEquals(expected, solution1223.dieSimulator(n, rollMax));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] rollMax = {1, 1, 1, 2, 2, 3};
        int expected = 181;
        Assertions.assertEquals(expected, solution1223.dieSimulator(n, rollMax));
    }
}