import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2071Tests {
    private final Solution2071 solution2071 = new Solution2071();

    @Test
    public void example1() {
        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        int pills = 1;
        int strength = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution2071.maxTaskAssign(tasks, workers, pills, strength));
    }

    @Test
    public void example2() {
        int[] tasks = {5, 4};
        int[] workers = {0, 0, 0};
        int pills = 1;
        int strength = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution2071.maxTaskAssign(tasks, workers, pills, strength));
    }

    @Test
    public void example3() {
        int[] tasks = {10, 15, 30};
        int[] workers = {0, 10, 10, 10, 10};
        int pills = 3;
        int strength = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solution2071.maxTaskAssign(tasks, workers, pills, strength));
    }

    @Test
    public void example4() {
        int[] tasks = {5, 9, 8, 5, 9};
        int[] workers = {1, 6, 4, 2, 6};
        int pills = 1;
        int strength = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solution2071.maxTaskAssign(tasks, workers, pills, strength));
    }
}
