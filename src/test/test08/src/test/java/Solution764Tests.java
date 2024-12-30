import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution764Tests {
    private final Solution764 solution764 = new Solution764();

    @Test
    public void example1() {
        int n = 5;
        int[][] mines = UtUtils.stringToInts2("[[4, 2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution764.orderOfLargestPlusSign(n, mines));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] mines = UtUtils.stringToInts2("[[0, 0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution764.orderOfLargestPlusSign(n, mines));
    }
}
