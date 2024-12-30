import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1406Tests {
    private final Solution1406 solution1406 = new Solution1406();

    @Test
    public void example1() {
        int[] stoneValue = {1, 2, 3, 7};
        String expected = "Bob";
        Assertions.assertEquals(expected, solution1406.stoneGameIII(stoneValue));
    }

    @Test
    public void example2() {
        int[] stoneValue = {1, 2, 3, -9};
        String expected = "Alice";
        Assertions.assertEquals(expected, solution1406.stoneGameIII(stoneValue));
    }

    @Test
    public void example3() {
        int[] stoneValue = {1, 2, 3, 6};
        String expected = "Tie";
        Assertions.assertEquals(expected, solution1406.stoneGameIII(stoneValue));
    }

    @Test
    public void example4() {
        int[] stoneValue = {1, 2, 3, -1, -2, -3, 7};
        String expected = "Alice";
        Assertions.assertEquals(expected, solution1406.stoneGameIII(stoneValue));
    }

    @Test
    public void example5() {
        int[] stoneValue = {-1, -2, -3};
        String expected = "Tie";
        Assertions.assertEquals(expected, solution1406.stoneGameIII(stoneValue));
    }
}
