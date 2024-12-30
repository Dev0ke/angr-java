import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3219Tests {
    private final Solution3219 solution3219 = new Solution3219();

    @Test
    public void example1() {
        int m = 3;
        int n = 2;
        int[] horizontalCut = {1, 3};
        int[] verticalCut = {5};
        long expected = 13;
        Assertions.assertEquals(expected, solution3219.minimumCost(m, n, horizontalCut, verticalCut));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 2;
        int[] horizontalCut = {7};
        int[] verticalCut = {4};
        long expected = 15;
        Assertions.assertEquals(expected, solution3219.minimumCost(m, n, horizontalCut, verticalCut));
    }
}