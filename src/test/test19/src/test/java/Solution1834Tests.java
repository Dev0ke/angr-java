import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1834Tests {
    private final Solution1834 solution1834 = new Solution1834();

    @Test
    public void example1() {
        int[][] tasks = UtUtils.stringToInts2("[[1,2],[2,4],[3,2],[4,1]]");
        int[] expected = {0, 2, 3, 1};
        Assertions.assertArrayEquals(expected, solution1834.getOrder(tasks));
    }

    @Test
    public void example2() {
        int[][] tasks = UtUtils.stringToInts2("[[7,10],[7,12],[7,5],[7,4],[7,2]]");
        int[] expected = {4, 3, 2, 0, 1};
        Assertions.assertArrayEquals(expected, solution1834.getOrder(tasks));
    }
}