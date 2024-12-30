import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1235Tests {
    private final Solution1235 solution1235 = new Solution1235();

    @Test
    public void example1() {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        int expected = 120;
        Assertions.assertEquals(expected, solution1235.jobScheduling(startTime, endTime, profit));
    }

    @Test
    public void example2() {
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        int expected = 150;
        Assertions.assertEquals(expected, solution1235.jobScheduling(startTime, endTime, profit));
    }

    @Test
    public void example3() {
        int[] startTime = {1, 1, 1};
        int[] endTime = {2, 3, 4};
        int[] profit = {5, 6, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution1235.jobScheduling(startTime, endTime, profit));
    }
}
