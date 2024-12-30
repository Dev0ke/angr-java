import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2548Tests {
    private final SolutionP2548 solutionP2548 = new SolutionP2548();

    @Test
    public void example1() {
        int[][] items = UtUtils.stringToInts2("[[50,1],[10,8]]");
        int capacity = 5;
        double expected = 55.00000;
        Assertions.assertEquals(expected, solutionP2548.maxPrice(items, capacity));
    }

    @Test
    public void example2() {
        int[][] items = UtUtils.stringToInts2("[[100,30]]");
        int capacity = 50;
        double expected = -1.00000;
        Assertions.assertEquals(expected, solutionP2548.maxPrice(items, capacity));
    }
}