import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1167Tests {
    private final SolutionP1167 solutionP1167 = new SolutionP1167();

    @Test
    public void example1() {
        int[] sticks = {2, 4, 3};
        int expected = 14;
        Assertions.assertEquals(expected, solutionP1167.connectSticks(sticks));
    }

    @Test
    public void example2() {
        int[] sticks = {1, 8, 3, 5};
        int expected = 30;
        Assertions.assertEquals(expected, solutionP1167.connectSticks(sticks));
    }

    @Test
    public void example3() {
        int[] sticks = {5};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1167.connectSticks(sticks));
    }
}