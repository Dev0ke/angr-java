import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution77Tests {
    private final Solution77.V1 solution77_v1 = new Solution77.V1();
    private final Solution77.V2 solution77_v2 = new Solution77.V2();

    @Test
    public void example1() {
        int n = 4;
        int k = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [2,4],
                  [3,4],
                  [2,3],
                  [1,2],
                  [1,3],
                  [1,4],
                ]
                """);
        List<List<Integer>> actual = solution77_v1.combine(n, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example1_1() {
        int n = 4;
        int k = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [2,4],
                  [3,4],
                  [2,3],
                  [1,2],
                  [1,3],
                  [1,4],
                ]
                """);
        List<List<Integer>> actual = solution77_v2.combine(n, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [[1]]
                """);
        List<List<Integer>> actual = solution77_v1.combine(n, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2_2() {
        int n = 1;
        int k = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [[1]]
                """);
        List<List<Integer>> actual = solution77_v2.combine(n, k);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
