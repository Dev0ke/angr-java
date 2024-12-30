import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2008Tests {
    private final Solution2008 solution2008 = new Solution2008();

    @Test
    public void example1() {
        int n = 5;
        int[][] rides = UtUtils.stringToInts2("[[2,5,4],[1,5,1]]");
        long expected = 7;
        Assertions.assertEquals(expected, solution2008.maxTaxiEarnings(n, rides));
        Assertions.assertEquals(expected, solution2008.maxTaxiEarnings2(n, rides));
    }

    @Test
    public void example2() {
        int n = 20;
        int[][] rides = UtUtils.stringToInts2("[[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]");
        long expected = 20;
        Assertions.assertEquals(expected, solution2008.maxTaxiEarnings(n, rides));
        Assertions.assertEquals(expected, solution2008.maxTaxiEarnings2(n, rides));
    }
}
