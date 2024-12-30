import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1301Tests {
    private final Solution1301 solution1301 = new Solution1301();

    @Test
    public void example1() {
        List<String> board = Arrays.asList("E23", "2X2", "12S");
        int[] expected = {7, 1};
        Assertions.assertArrayEquals(expected, solution1301.pathsWithMaxScore(board));
    }

    @Test
    public void example2() {
        List<String> board = Arrays.asList("E12", "1X1", "21S");
        int[] expected = {4, 2};
        Assertions.assertArrayEquals(expected, solution1301.pathsWithMaxScore(board));
    }

    @Test
    public void example3() {
        List<String> board = Arrays.asList("E11", "XXX", "11S");
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution1301.pathsWithMaxScore(board));
    }
}