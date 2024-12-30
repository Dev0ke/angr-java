import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3257Tests {
    private final Solution3257 solution3257 = new Solution3257();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[-3,1,1,1],[-3,1,-3,1],[-3,2,1,1]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution3257.maximumValueSum(board));
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        long expected = 15;
        Assertions.assertEquals(expected, solution3257.maximumValueSum(board));
    }

    @Test
    public void example3() {
        int[][] board = UtUtils.stringToInts2("[[1,1,1],[1,1,1],[1,1,1]]");
        long expected = 3;
        Assertions.assertEquals(expected, solution3257.maximumValueSum(board));
    }
}