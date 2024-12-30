import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution787Tests {
    private final Solution787 solution787 = new Solution787();

    @Test
    public void example1() {
        int n = 3;
        int[][] flights = UtUtils.stringToInts2("[[0,1,100],[1,2,100],[0,2,500]]");
        int src = 0;
        int dst = 2;
        int k = 1;
        int expected = 200;
        Assertions.assertEquals(expected, solution787.findCheapestPrice(n, flights, src, dst, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] flights = UtUtils.stringToInts2("[[0,1,100],[1,2,100],[0,2,500]]");
        int src = 0;
        int dst = 2;
        int k = 0;
        int expected = 500;
        Assertions.assertEquals(expected, solution787.findCheapestPrice(n, flights, src, dst, k));
    }
}
