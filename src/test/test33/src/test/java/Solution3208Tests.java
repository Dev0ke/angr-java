import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3208Tests {
    private final Solution3208 solution3208 = new Solution3208();

    @Test
    public void example1() {
        int[] colors = {0, 1, 0, 1, 0};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3208.numberOfAlternatingGroups(colors, k));
    }

    @Test
    public void example2() {
        int[] colors = {0, 1, 0, 0, 1, 0, 1};
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution3208.numberOfAlternatingGroups(colors, k));
    }

    @Test
    public void example3() {
        int[] colors = {1, 1, 0, 1};
        int k = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution3208.numberOfAlternatingGroups(colors, k));
    }
}