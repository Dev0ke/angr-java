import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1817Tests {
    private final Solution1817 solution1817 = new Solution1817();

    @Test
    public void example1() {
        int[][] logs = UtUtils.stringToInts2("[[0,5],[1,2],[0,2],[0,5],[1,3]]");
        int k = 5;
        int[] expected = {0, 2, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution1817.findingUsersActiveMinutes(logs, k));
    }

    @Test
    public void example2() {
        int[][] logs = UtUtils.stringToInts2("[[1,1],[2,2],[2,3]]");
        int k = 4;
        int[] expected = {1, 1, 0, 0};
        Assertions.assertArrayEquals(expected, solution1817.findingUsersActiveMinutes(logs, k));
    }
}