import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2078Tests {
    private final Solution2078 solution2078 = new Solution2078();

    @Test
    public void example1() {
        int[] colors = {1, 1, 1, 6, 1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution2078.maxDistance(colors));
    }

    @Test
    public void example2() {
        int[] colors = {1, 8, 3, 8, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution2078.maxDistance(colors));
    }

    @Test
    public void example3() {
        int[] colors = {0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution2078.maxDistance(colors));
    }
}
