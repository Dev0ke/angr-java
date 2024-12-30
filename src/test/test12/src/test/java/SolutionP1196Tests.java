import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1196Tests {
    private final SolutionP1196 solutionP1196 = new SolutionP1196();

    @Test
    public void example1() {
        int[] weight = {100, 200, 150, 1000};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1196.maxNumberOfApples(weight));
    }

    @Test
    public void example2() {
        int[] weight = {900, 950, 800, 1000, 700, 800};
        int expected = 5;
        Assertions.assertEquals(expected, solutionP1196.maxNumberOfApples(weight));
    }
}
