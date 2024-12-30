import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1439Tests {
    private final Solution1439 solution1439 = new Solution1439();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,3,11],[2,4,6]]");
        int k = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solution1439.kthSmallest(mat, k));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,3,11],[2,4,6]]");
        int k = 9;
        int expected = 17;
        Assertions.assertEquals(expected, solution1439.kthSmallest(mat, k));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[1,10,10],[1,4,5],[2,3,6]]");
        int k = 7;
        int expected = 9;
        Assertions.assertEquals(expected, solution1439.kthSmallest(mat, k));
    }

    @Test
    public void example4() {
        int[][] mat = UtUtils.stringToInts2("[[1,1,10],[2,2,9]]");
        int k = 7;
        int expected = 12;
        Assertions.assertEquals(expected, solution1439.kthSmallest(mat, k));
    }
}
