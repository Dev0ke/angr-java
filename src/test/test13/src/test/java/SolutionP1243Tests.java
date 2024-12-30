import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1243Tests {
    private final SolutionP1243 solutionP1243 = new SolutionP1243();

    @Test
    public void example1() {
        int[] arr = {6, 2, 3, 4};
        List<Integer> expected = List.of(6, 3, 3, 4);
        Assertions.assertEquals(expected, solutionP1243.transformArray(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 6, 3, 4, 3, 5};
        List<Integer> expected = List.of(1, 4, 4, 4, 4, 5);
        Assertions.assertEquals(expected, solutionP1243.transformArray(arr));
    }
}