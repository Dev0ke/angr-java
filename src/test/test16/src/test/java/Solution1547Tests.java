import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1547Tests {
    private final Solution1547 solution1547 = new Solution1547();

    @Test
    public void example1() {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        int expected = 16;
        Assertions.assertEquals(expected, solution1547.minCost(n, cuts));
    }

    @Test
    public void example2() {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        int expected = 22;
        Assertions.assertEquals(expected, solution1547.minCost(n, cuts));
    }
}
