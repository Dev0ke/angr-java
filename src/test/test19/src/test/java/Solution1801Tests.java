import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1801Tests {
    private final Solution1801 solution1801 = new Solution1801();

    @Test
    public void example1() {
        int[][] orders = UtUtils.stringToInts2("[[10,5,0],[15,2,1],[25,1,1],[30,4,0]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution1801.getNumberOfBacklogOrders(orders));
    }

    @Test
    public void example2() {
        int[][] orders = UtUtils.stringToInts2("[[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]");
        int expected = 999999984;
        Assertions.assertEquals(expected, solution1801.getNumberOfBacklogOrders(orders));
    }
}
