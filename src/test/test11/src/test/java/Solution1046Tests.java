import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1046Tests {
    private final Solution1046 solution1046 = new Solution1046();

    @Test
    public void example1() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1046.lastStoneWeight(stones));
    }
}
