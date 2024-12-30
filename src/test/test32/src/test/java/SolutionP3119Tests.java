import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3119Tests {
    private final SolutionP3119 solutionP3119 = new SolutionP3119();

    @Test
    public void example1() {
        String road = "..";
        int budget = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3119.maxPotholes(road, budget));
    }

    @Test
    public void example2() {
        String road = "..xxxxx";
        int budget = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3119.maxPotholes(road, budget));
    }

    @Test
    public void example3() {
        String road = "x.x.xxx...x";
        int budget = 14;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3119.maxPotholes(road, budget));
    }
}