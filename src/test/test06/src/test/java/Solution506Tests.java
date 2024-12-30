import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution506Tests {
    private final Solution506 solution506 = new Solution506();

    @Test
    public void example1() {
        int[] score = {5, 4, 3, 2, 1};
        String[] expected = {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
        Assertions.assertArrayEquals(expected, solution506.findRelativeRanks(score));
    }

    @Test
    public void example2() {
        int[] score = {10, 3, 8, 9, 4};
        String[] expected = {"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"};
        Assertions.assertArrayEquals(expected, solution506.findRelativeRanks(score));
    }
}
