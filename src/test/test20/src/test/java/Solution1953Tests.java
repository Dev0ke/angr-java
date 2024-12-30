import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1953Tests {
    private final Solution1953 solution1953 = new Solution1953();

    @Test
    public void example1() {
        int[] milestones = {1, 2, 3};
        long expected = 6;
        Assertions.assertEquals(expected, solution1953.numberOfWeeks(milestones));
    }

    @Test
    public void example2() {
        int[] milestones = {5, 2, 1};
        long expected = 7;
        Assertions.assertEquals(expected, solution1953.numberOfWeeks(milestones));
    }
}
