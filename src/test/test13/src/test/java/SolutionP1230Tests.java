import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1230Tests {
    private final SolutionP1230 solutionP1230 = new SolutionP1230();

    @Test
    public void example1() {
        double[] prob = {0.4};
        int target = 1;
        double expected = 0.40000;
        Assertions.assertEquals(expected, solutionP1230.probabilityOfHeads(prob, target));
    }

    @Test
    public void example2() {
        double[] prob = {0.5, 0.5, 0.5, 0.5, 0.5};
        int target = 0;
        double expected = 0.03125;
        Assertions.assertEquals(expected, solutionP1230.probabilityOfHeads(prob, target));
    }
}