import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2280Tests {
    private final Solution2280 solution2280 = new Solution2280();

    @Test
    public void example1() {
        int[][] stockPrices = UtUtils.stringToInts2("[[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2280.minimumLines(stockPrices));
    }

    @Test
    public void example2() {
        int[][] stockPrices = UtUtils.stringToInts2("[[3,4],[1,2],[7,8],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2280.minimumLines(stockPrices));
    }
}
