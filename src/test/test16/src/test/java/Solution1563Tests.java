import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1563Tests {
    private final Solution1563 solution1563 = new Solution1563();

    @Test
    public void example1() {
        int[] stoneValue = {6, 2, 3, 4, 5, 5};
        int expected = 18;
        Assertions.assertEquals(expected, solution1563.stoneGameV(stoneValue));
    }

    @Test
    public void example2() {
        int[] stoneValue = {7, 7, 7, 7, 7, 7, 7};
        int expected = 28;
        Assertions.assertEquals(expected, solution1563.stoneGameV(stoneValue));
    }

    @Test
    public void example3() {
        int[] stoneValue = {4};
        int expected = 0;
        Assertions.assertEquals(expected, solution1563.stoneGameV(stoneValue));
    }
}