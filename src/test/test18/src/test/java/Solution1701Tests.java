import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1701Tests {
    private final Solution1701 solution1701 = new Solution1701();

    @Test
    public void example1() {
        int[][] customers = UtUtils.stringToInts2("[[1,2],[2,5],[4,3]]");
        double expected = 5.00000;
        Assertions.assertEquals(expected, solution1701.averageWaitingTime(customers), 1e-5);
    }

    @Test
    public void example2() {
        int[][] customers = UtUtils.stringToInts2("[[5,2],[5,4],[10,3],[20,1]]");
        double expected = 3.25000;
        Assertions.assertEquals(expected, solution1701.averageWaitingTime(customers), 1e-5);
    }
}
