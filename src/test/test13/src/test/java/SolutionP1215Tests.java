import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1215Tests {
    private final SolutionP1215 solutionP1215 = new SolutionP1215();

    @Test
    public void example1() {
        int low = 0;
        int high = 21;
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21);
        Assertions.assertEquals(expected, solutionP1215.countSteppingNumbers(low, high));
    }
}