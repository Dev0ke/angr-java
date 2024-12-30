import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP465Tests {
    private final SolutionP465 solutionP465 = new SolutionP465();

    @Test
    public void example1() {
        int[][] transactions = UtUtils.stringToInts2("[[0,1,10], [2,0,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP465.minTransfers(transactions));
    }

    @Test
    public void example2() {
        int[][] transactions = UtUtils.stringToInts2("[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP465.minTransfers(transactions));
    }
}
