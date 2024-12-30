import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1491Tests {
    private final Solution1491 solution1491 = new Solution1491();

    @Test
    public void example1() {
        int[] salary = {4000, 3000, 1000, 2000};
        double expected = 2500.00000;
        Assertions.assertEquals(expected, solution1491.average(salary));
    }

    @Test
    public void example2() {
        int[] salary = {1000, 2000, 3000};
        double expected = 2000.00000;
        Assertions.assertEquals(expected, solution1491.average(salary));
    }

    @Test
    public void example3() {
        int[] salary = {6000, 5000, 4000, 3000, 2000, 1000};
        double expected = 3500.00000;
        Assertions.assertEquals(expected, solution1491.average(salary));
    }

    @Test
    public void example4() {
        int[] salary = {8000, 9000, 2000, 3000, 6000, 1000};
        double expected = 4750.00000;
        Assertions.assertEquals(expected, solution1491.average(salary));
    }
}
