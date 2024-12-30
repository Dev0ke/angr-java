import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2212Tests {
    private final Solution2212 solution2212 = new Solution2212();

    @Test
    public void example1() {
        int numArrows = 9;
        int[] aliceArrows = {1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0};
        int[] expected = {0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1};
        Assertions.assertArrayEquals(expected, solution2212.maximumBobPoints(numArrows, aliceArrows));
    }

    @Test
    public void example2() {
        int numArrows = 3;
        int[] aliceArrows = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution2212.maximumBobPoints(numArrows, aliceArrows));
    }

    // 补充用例
    @Test
    public void example3() {
        int numArrows = 89;
        int[] aliceArrows = {3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5};
        int[] expected = {21, 3, 0, 2, 8, 2, 17, 8, 4, 14, 4, 6};
        Assertions.assertArrayEquals(expected, solution2212.maximumBobPoints(numArrows, aliceArrows));
    }
}