import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1090Tests {
    private final Solution1090 solution1090 = new Solution1090();

    @Test
    public void example1() {
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 1, 2, 2, 3};
        int numWanted = 3;
        int useLimit = 1;
        int expected = 9;
        Assertions.assertEquals(expected, solution1090.largestValsFromLabels(values, labels, numWanted, useLimit));
    }

    @Test
    public void example2() {
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 3, 3, 3, 2};
        int numWanted = 3;
        int useLimit = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solution1090.largestValsFromLabels(values, labels, numWanted, useLimit));
    }

    @Test
    public void example3() {
        int[] values = {9, 8, 8, 7, 6};
        int[] labels = {0, 0, 0, 1, 1};
        int numWanted = 3;
        int useLimit = 1;
        int expected = 16;
        Assertions.assertEquals(expected, solution1090.largestValsFromLabels(values, labels, numWanted, useLimit));
    }
}