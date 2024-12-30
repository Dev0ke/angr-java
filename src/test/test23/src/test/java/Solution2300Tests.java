import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2300Tests {
    private final Solution2300 solution2300 = new Solution2300();

    @Test
    public void example1() {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        int[] expected = {4, 0, 3};
        Assertions.assertArrayEquals(expected, solution2300.successfulPairs(spells, potions, success));
    }

    @Test
    public void example2() {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        long success = 16;
        int[] expected = {2, 0, 2};
        Assertions.assertArrayEquals(expected, solution2300.successfulPairs(spells, potions, success));
    }
}
