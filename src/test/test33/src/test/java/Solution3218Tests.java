import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3218Tests {
    private final Solution3218 solution3218 = new Solution3218();

    @Test
    public void example1() {
        int m = 3;
        int n = 2;
        int[] horizontalCut = {1, 3};
        int[] verticalCut = {5};
        int expected = 13;
        Assertions.assertEquals(expected, solution3218.minimumCost(m, n, horizontalCut, verticalCut));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 2;
        int[] horizontalCut = {7};
        int[] verticalCut = {4};
        int expected = 15;
        Assertions.assertEquals(expected, solution3218.minimumCost(m, n, horizontalCut, verticalCut));
    }
}