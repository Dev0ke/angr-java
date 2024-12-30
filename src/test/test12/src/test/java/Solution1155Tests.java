import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1155Tests {
    private final Solution1155 solution1155 = new Solution1155();

    @Test
    public void example1() {
        int n = 1;
        int k = 6;
        int target = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1155.numRollsToTarget(n, k, target));
    }

    @Test
    public void example2() {
        int n = 2;
        int k = 6;
        int target = 7;
        int expected = 6;
        Assertions.assertEquals(expected, solution1155.numRollsToTarget(n, k, target));
    }

    @Test
    public void example3() {
        int n = 30;
        int k = 30;
        int target = 500;
        int expected = 222616187;
        Assertions.assertEquals(expected, solution1155.numRollsToTarget(n, k, target));
    }
}
