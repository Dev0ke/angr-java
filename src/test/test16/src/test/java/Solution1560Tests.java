import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1560Tests {
    private final Solution1560 solution1560 = new Solution1560();

    @Test
    public void example1() {
        int n = 4;
        int[] rounds = {1, 3, 1, 2};
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution1560.mostVisited(n, rounds));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] rounds = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, solution1560.mostVisited(n, rounds));
    }

    @Test
    public void example3() {
        int n = 7;
        int[] rounds = {1, 3, 5, 7};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertEquals(expected, solution1560.mostVisited(n, rounds));
    }
}