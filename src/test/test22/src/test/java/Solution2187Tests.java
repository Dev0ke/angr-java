import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2187Tests {
    private final Solution2187 solution2187 = new Solution2187();

    @Test
    public void example1() {
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        long expected = 3;
        Assertions.assertEquals(expected, solution2187.minimumTime(time, totalTrips));
    }

    @Test
    public void example2() {
        int[] time = {2};
        int totalTrips = 1;
        long expected = 2;
        Assertions.assertEquals(expected, solution2187.minimumTime(time, totalTrips));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] time = {39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25};
        int totalTrips = 4187;
        long expected = 858;
        Assertions.assertEquals(expected, solution2187.minimumTime(time, totalTrips));
    }

    @Test
    public void example4() {
        int[] time = {10000000};
        int totalTrips = 10000000;
        long expected = 100000000000000L;
        Assertions.assertEquals(expected, solution2187.minimumTime(time, totalTrips));
    }
}