import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1033Tests {
    private final Solution1033 solution1033 = new Solution1033();

    @Test
    public void example1() {
        int a = 1;
        int b = 2;
        int c = 5;
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution1033.numMovesStones(a, b, c));
    }

    @Test
    public void example2() {
        int a = 4;
        int b = 3;
        int c = 2;
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution1033.numMovesStones(a, b, c));
    }
}