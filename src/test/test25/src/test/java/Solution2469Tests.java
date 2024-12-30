import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2469Tests {
    private final Solution2469 solution2469 = new Solution2469();

    @Test
    public void example1() {
        double celsius = 36.50;
        double[] expected = {309.65000, 97.70000};
        Assertions.assertArrayEquals(expected, solution2469.convertTemperature(celsius));
    }

    @Test
    public void example2() {
        double celsius = 122.11;
        double[] expected = {395.26000, 251.79800};
        Assertions.assertArrayEquals(expected, solution2469.convertTemperature(celsius));
    }
}
