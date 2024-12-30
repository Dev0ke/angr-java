import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1058Tests {
    private final SolutionP1058 solutionP1058 = new SolutionP1058();

    @Test
    public void example1() {
        String[] prices = {"0.700", "2.800", "4.900"};
        int target = 8;
        String expected = "1.000";
        Assertions.assertEquals(expected, solutionP1058.minimizeError(prices, target));
    }

    @Test
    public void example2() {
        String[] prices = {"1.500", "2.500", "3.500"};
        int target = 10;
        String expected = "-1";
        Assertions.assertEquals(expected, solutionP1058.minimizeError(prices, target));
    }

    @Test
    public void example3() {
        String[] prices = {"1.500", "2.500", "3.500"};
        int target = 9;
        String expected = "1.500";
        Assertions.assertEquals(expected, solutionP1058.minimizeError(prices, target));
    }
}
