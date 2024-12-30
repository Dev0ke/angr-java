import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1672Tests {
    private final Solution1672 solution1672 = new Solution1672();

    @Test
    public void example1() {
        int[][] accounts = UtUtils.stringToInts2("[[1,2,3],[3,2,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution1672.maximumWealth(accounts));
    }

    @Test
    public void example2() {
        int[][] accounts = UtUtils.stringToInts2("[[1,5],[7,3],[3,5]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution1672.maximumWealth(accounts));
    }

    @Test
    public void example3() {
        int[][] accounts = UtUtils.stringToInts2("[[2,8,7],[7,1,3],[1,9,5]]");
        int expected = 17;
        Assertions.assertEquals(expected, solution1672.maximumWealth(accounts));
    }
}
