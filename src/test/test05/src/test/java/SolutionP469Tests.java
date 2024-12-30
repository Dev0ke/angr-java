import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP469Tests {
    private final SolutionP469 solutionP469 = new SolutionP469();

    @Test
    public void example1() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[0,0],[0,5],[5,5],[5,0]]");
        Assertions.assertTrue(solutionP469.isConvex(points));
    }

    @Test
    public void example2() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[0,0],[0,10],[10,10],[10,0],[5,5]]");
        Assertions.assertFalse(solutionP469.isConvex(points));
    }
}
