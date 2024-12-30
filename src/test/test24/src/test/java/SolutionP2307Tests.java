import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP2307Tests {
    private final SolutionP2307 solutionP2307 = new SolutionP2307();

    @Test
    public void example1() {
        List<List<String>> equations = UtUtils.stringToStringList2("""
                [["a","b"],["b","c"],["a","c"]]
                """);
        double[] values = {3, 0.5, 1.5};
        Assertions.assertFalse(solutionP2307.checkContradictions(equations, values));
    }

    @Test
    public void example2() {
        List<List<String>> equations = UtUtils.stringToStringList2("""
                [["le","et"],["le","code"],["code","et"]]
                """);
        double[] values = {2, 5, 0.5};
        Assertions.assertTrue(solutionP2307.checkContradictions(equations, values));
    }
}