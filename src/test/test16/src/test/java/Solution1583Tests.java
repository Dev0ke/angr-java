import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1583Tests {
    private final Solution1583 solution1583 = new Solution1583();

    @Test
    public void example1() {
        int n = 4;
        int[][] preferences = UtUtils.stringToInts2("[[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]]");
        int[][] pairs = UtUtils.stringToInts2("[[0, 1], [2, 3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1583.unhappyFriends(n, preferences, pairs));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] preferences = UtUtils.stringToInts2("[[1], [0]]");
        int[][] pairs = UtUtils.stringToInts2("[[1, 0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1583.unhappyFriends(n, preferences, pairs));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] preferences = UtUtils.stringToInts2("[[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]]");
        int[][] pairs = UtUtils.stringToInts2("[[1, 3], [0, 2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1583.unhappyFriends(n, preferences, pairs));
    }
}