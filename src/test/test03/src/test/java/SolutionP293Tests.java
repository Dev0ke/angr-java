import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionP293Tests {
    private final SolutionP293 solutionP293 = new SolutionP293();

    @Test
    public void example1() {
        String currentState = "++++";
        List<String> expected = Arrays.asList("--++", "+--+", "++--");
        Assertions.assertEquals(expected, solutionP293.generatePossibleNextMoves(currentState));
    }

    @Test
    public void example2() {
        String currentState = "+";
        List<String> expected = Arrays.asList();
        Assertions.assertEquals(expected, solutionP293.generatePossibleNextMoves(currentState));
    }
}