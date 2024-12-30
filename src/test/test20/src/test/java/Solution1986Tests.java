import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1986Tests {
    private final Solution1986 solution1986 = new Solution1986();

    @Test
    public void example1() {
        int[] tasks = {1, 2, 3};
        int sessionTime = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1986.minSessions(tasks, sessionTime));
    }

    @Test
    public void example2() {
        int[] tasks = {3, 1, 3, 1, 1};
        int sessionTime = 8;
        int expected = 2;
        Assertions.assertEquals(expected, solution1986.minSessions(tasks, sessionTime));
    }

    @Test
    public void example3() {
        int[] tasks = {1, 2, 3, 4, 5};
        int sessionTime = 15;
        int expected = 1;
        Assertions.assertEquals(expected, solution1986.minSessions(tasks, sessionTime));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] tasks = {1, 5, 7, 10, 3, 8, 4, 2, 6, 2};
        int sessionTime = 10;
        int expected = 5;
        Assertions.assertEquals(expected, solution1986.minSessions(tasks, sessionTime));
    }

    @Test
    public void example5() {
        int[] tasks = {2};
        int sessionTime = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution1986.minSessions(tasks, sessionTime));
    }

    @Test
    public void example6() {
        int[] tasks = {2, 3, 3, 4, 4, 4, 5, 6, 7, 10};
        int sessionTime = 12;
        int expected = 4;
        Assertions.assertEquals(expected, solution1986.minSessions(tasks, sessionTime));
    }
}