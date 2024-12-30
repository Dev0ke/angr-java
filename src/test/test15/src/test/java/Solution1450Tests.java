import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1450Tests {
    private final Solution1450 solution1450 = new Solution1450();

    @Test
    public void example1() {
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int queryTime = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution1450.busyStudent(startTime, endTime, queryTime));
    }

    @Test
    public void example2() {
        int[] startTime = {4};
        int[] endTime = {4};
        int queryTime = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution1450.busyStudent(startTime, endTime, queryTime));
    }

    @Test
    public void example3() {
        int[] startTime = {4};
        int[] endTime = {4};
        int queryTime = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution1450.busyStudent(startTime, endTime, queryTime));
    }

    @Test
    public void example4() {
        int[] startTime = {1, 1, 1, 1};
        int[] endTime = {1, 3, 2, 4};
        int queryTime = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution1450.busyStudent(startTime, endTime, queryTime));
    }

    @Test
    public void example5() {
        int[] startTime = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] endTime = {10, 10, 10, 10, 10, 10, 10, 10, 10};
        int queryTime = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution1450.busyStudent(startTime, endTime, queryTime));
    }
}
