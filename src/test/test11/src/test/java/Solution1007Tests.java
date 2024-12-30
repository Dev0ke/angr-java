import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1007Tests {
    private final Solution1007 solution1007 = new Solution1007();

    @Test
    public void example1() {
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution1007.minDominoRotations(tops, bottoms));
    }

    @Test
    public void example2() {
        int[] tops = {3, 5, 1, 2, 3};
        int[] bottoms = {3, 6, 3, 3, 4};
        int expected = -1;
        Assertions.assertEquals(expected, solution1007.minDominoRotations(tops, bottoms));
    }
}
