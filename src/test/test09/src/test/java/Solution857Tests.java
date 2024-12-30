import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution857Tests {
    private final Solution857 solution857 = new Solution857();

    @Test
    public void example1() {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        double expected = 105.00000;
        Assertions.assertEquals(expected, solution857.mincostToHireWorkers(quality, wage, k));
    }

    @Test
    public void example2() {
        int[] quality = {3, 1, 10, 10, 1};
        int[] wage = {4, 8, 2, 2, 7};
        int k = 3;
        double expected = 30.66667;
        Assertions.assertEquals(expected, solution857.mincostToHireWorkers(quality, wage, k), 1e-5);
    }
}