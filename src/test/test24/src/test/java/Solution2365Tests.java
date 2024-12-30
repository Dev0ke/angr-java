import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2365Tests {
    private final Solution2365 solution2365 = new Solution2365();

    @Test
    public void example1() {
        int[] tasks = {1, 2, 1, 2, 3, 1};
        int space = 3;
        long expected = 9;
        Assertions.assertEquals(expected, solution2365.taskSchedulerII(tasks, space));
    }

    @Test
    public void example2() {
        int[] tasks = {5, 8, 8, 5};
        int space = 2;
        long expected = 6;
        Assertions.assertEquals(expected, solution2365.taskSchedulerII(tasks, space));
    }
}
