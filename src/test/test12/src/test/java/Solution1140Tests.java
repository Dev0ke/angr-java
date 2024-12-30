import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1140Tests {
    private final Solution1140 solution1140 = new Solution1140();

    @Test
    public void example1() {
        int[] piles = {2, 7, 9, 4, 4};
        int expected = 10;
        Assertions.assertEquals(expected, solution1140.stoneGameII(piles));
    }

    @Test
    public void example2() {
        int[] piles = {1, 2, 3, 4, 5, 100};
        int expected = 104;
        Assertions.assertEquals(expected, solution1140.stoneGameII(piles));
    }
}
