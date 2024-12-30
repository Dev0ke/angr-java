import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2661Tests {
    private final Solution2661 solution2661 = new Solution2661();

    @Test
    public void example1() {
        int[] arr = {1, 3, 4, 2};
        int[][] mat = UtUtils.stringToInts2("[[1,4],[2,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2661.firstCompleteIndex(arr, mat));
    }

    @Test
    public void example2() {
        int[] arr = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat = UtUtils.stringToInts2("[[3,2,5],[1,4,6],[8,7,9]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2661.firstCompleteIndex(arr, mat));
    }
}