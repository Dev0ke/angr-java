import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2861Tests {
    private final Solution2861 solution2861 = new Solution2861();

    @Test
    public void example1() {
        int n = 3;
        int k = 2;
        int budget = 15;
        List<List<Integer>> composition = UtUtils.stringToIntegerList2("[[1,1,1],[1,1,10]]");
        List<Integer> stock = List.of(0, 0, 0);
        List<Integer> cost = List.of(1, 2, 3);
        int expected = 2;
        Assertions.assertEquals(expected, solution2861.maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 2;
        int budget = 15;
        List<List<Integer>> composition = UtUtils.stringToIntegerList2("[[1,1,1],[1,1,10]]");
        List<Integer> stock = List.of(0, 0, 100);
        List<Integer> cost = List.of(1, 2, 3);
        int expected = 5;
        Assertions.assertEquals(expected, solution2861.maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }

    @Test
    public void example3() {
        int n = 2;
        int k = 3;
        int budget = 10;
        List<List<Integer>> composition = UtUtils.stringToIntegerList2("[[2,1],[1,2],[1,1]]");
        List<Integer> stock = List.of(1, 1);
        List<Integer> cost = List.of(5, 5);
        int expected = 2;
        Assertions.assertEquals(expected, solution2861.maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }
}