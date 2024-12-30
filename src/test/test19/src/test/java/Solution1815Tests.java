import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1815Tests {
    private final Solution1815 solution1815 = new Solution1815();

    @Test
    public void example1() {
        int batchSize = 3;
        int[] groups = {1, 2, 3, 4, 5, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution1815.maxHappyGroups(batchSize, groups));
    }

    @Test
    public void example2() {
        int batchSize = 4;
        int[] groups = {1, 3, 2, 5, 2, 2, 1, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solution1815.maxHappyGroups(batchSize, groups));
    }
}