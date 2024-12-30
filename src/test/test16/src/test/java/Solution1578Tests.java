import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1578Tests {
    private final Solution1578 solution1578 = new Solution1578();

    @Test
    public void example1() {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution1578.minCost(colors, neededTime));
    }

    @Test
    public void example2() {
        String colors = "abc";
        int[] neededTime = {1, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1578.minCost(colors, neededTime));
    }

    @Test
    public void example3() {
        String colors = "aabaa";
        int[] neededTime = {1, 2, 3, 4, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1578.minCost(colors, neededTime));
    }
}