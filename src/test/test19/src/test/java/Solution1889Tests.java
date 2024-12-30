import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1889Tests {
    private final Solution1889 solution1889 = new Solution1889();

    @Test
    public void example1() {
        int[] packages = {2, 3, 5};
        int[][] boxes = UtUtils.stringToInts2("[[4,8],[2,8]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution1889.minWastedSpace(packages, boxes));
    }

    @Test
    public void example2() {
        int[] packages = {2, 3, 5};
        int[][] boxes = UtUtils.stringToInts2("[[1,4],[2,3],[3,4]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1889.minWastedSpace(packages, boxes));
    }

    @Test
    public void example3() {
        int[] packages = {3, 5, 8, 10, 11, 12};
        int[][] boxes = UtUtils.stringToInts2("[[12],[11,9],[10,5,14]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution1889.minWastedSpace(packages, boxes));
    }
}
