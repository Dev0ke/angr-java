import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2403Tests {
    private final SolutionP2403 solutionP2403 = new SolutionP2403();

    @Test
    public void example1() {
        int[] power = {3, 1, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2403.minimumTime(power));
    }

    @Test
    public void example2() {
        int[] power = {1, 1, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2403.minimumTime(power));
    }

    @Test
    public void example3() {
        int[] power = {1, 2, 4, 9};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2403.minimumTime(power));
    }
}