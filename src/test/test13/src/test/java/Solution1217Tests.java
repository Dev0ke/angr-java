import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1217Tests {
    private final Solution1217 solution1217 = new Solution1217();

    @Test
    public void example1() {
        int[] position = {1, 2, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution1217.minCostToMoveChips(position));
    }

    @Test
    public void example2() {
        int[] position = {2, 2, 2, 3, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution1217.minCostToMoveChips(position));
    }
}
