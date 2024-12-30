import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP254Tests {
    private final SolutionP254 solutionP254 = new SolutionP254();

    @Test
    public void example1() {
        int n = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solutionP254.getFactors(n));
    }

    @Test
    public void example2() {
        int n = 37;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solutionP254.getFactors(n));
    }

    @Test
    public void example3() {
        int n = 12;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [2, 6],
                  [2, 2, 3],
                  [3, 4]
                ]
                """);
        List<List<Integer>> actual = solutionP254.getFactors(n);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example4() {
        int n = 32;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [2, 16],
                  [2, 2, 8],
                  [2, 2, 2, 4],
                  [2, 2, 2, 2, 2],
                  [2, 4, 4],
                  [4, 8]
                ]
                """);
        List<List<Integer>> actual = solutionP254.getFactors(n);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
