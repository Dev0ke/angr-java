import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP1229Tests {
    private final SolutionP1229 solutionP1229 = new SolutionP1229();

    @Test
    public void example1() {
        int[][] slots1 = UtUtils.stringToInts2("[[10,50],[60,120],[140,210]]");
        int[][] slots2 = UtUtils.stringToInts2("[[0,15],[60,70]]");
        int duration = 8;
        List<Integer> expected = List.of(60, 68);
        Assertions.assertEquals(expected, solutionP1229.minAvailableDuration(slots1, slots2, duration));
    }

    @Test
    public void example2() {
        int[][] slots1 = UtUtils.stringToInts2("[[10,50],[60,120],[140,210]]");
        int[][] slots2 = UtUtils.stringToInts2("[[0,15],[60,70]]");
        int duration = 12;
        List<Integer> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solutionP1229.minAvailableDuration(slots1, slots2, duration));
    }
}
