import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2594Tests {
    private final Solution2594 solution2594 = new Solution2594();

    @Test
    public void example1() {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        long expected = 16;
        Assertions.assertEquals(expected, solution2594.repairCars(ranks, cars));
    }

    @Test
    public void example2() {
        int[] ranks = {5, 1, 8};
        int cars = 6;
        long expected = 16;
        Assertions.assertEquals(expected, solution2594.repairCars(ranks, cars));
    }
}