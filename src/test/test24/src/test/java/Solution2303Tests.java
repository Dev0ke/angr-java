import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2303Tests {
    private final Solution2303 solution2303 = new Solution2303();

    @Test
    public void example1() {
        int[][] brackets = UtUtils.stringToInts2("[[3,50],[7,10],[12,25]]");
        int income = 10;
        double expected = 2.65000;
        Assertions.assertEquals(expected, solution2303.calculateTax(brackets, income));
    }

    @Test
    public void example2() {
        int[][] brackets = UtUtils.stringToInts2("[[1,0],[4,25],[5,50]]");
        int income = 2;
        double expected = 0.25000;
        Assertions.assertEquals(expected, solution2303.calculateTax(brackets, income));
    }

    @Test
    public void example3() {
        int[][] brackets = UtUtils.stringToInts2("[[2,50]]");
        int income = 0;
        double expected = 0.00000;
        Assertions.assertEquals(expected, solution2303.calculateTax(brackets, income));
    }
}
