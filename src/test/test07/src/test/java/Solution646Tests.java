import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution646Tests {
    private final Solution646 solution646 = new Solution646();

    @Test
    public void example1() {
        int[][] pairs = UtUtils.stringToInts2("[[1,2], [2,3], [3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution646.findLongestChain(pairs));
    }
}
