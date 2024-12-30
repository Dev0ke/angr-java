import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2151Tests {
    private final Solution2151 solution2151 = new Solution2151();

    @Test
    public void example1() {
        int[][] statements = UtUtils.stringToInts2("[[2,1,2],[1,2,2],[2,0,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2151.maximumGood(statements));
    }

    @Test
    public void example2() {
        int[][] statements = UtUtils.stringToInts2("[[2,0],[0,2]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2151.maximumGood(statements));
    }
}
