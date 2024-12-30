import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1039Tests {
    private final Solution1039 solution1039 = new Solution1039();

    @Test
    public void example1() {
        int[] values = {1, 2, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution1039.minScoreTriangulation(values));
    }

    @Test
    public void example2() {
        int[] values = {3, 7, 4, 5};
        int expected = 144;
        Assertions.assertEquals(expected, solution1039.minScoreTriangulation(values));
    }

    @Test
    public void example3() {
        int[] values = {1, 3, 1, 4, 1, 5};
        int expected = 13;
        Assertions.assertEquals(expected, solution1039.minScoreTriangulation(values));
    }
}