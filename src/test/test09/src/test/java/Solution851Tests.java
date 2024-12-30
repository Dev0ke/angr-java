import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution851Tests {
    private final Solution851 solution851 = new Solution851();

    @Test
    public void example1() {
        int[][] richer = UtUtils.stringToInts2("[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]");
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] expected = {5, 5, 2, 5, 4, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solution851.loudAndRich(richer, quiet));
    }

    @Test
    public void example2() {
        int[][] richer = UtUtils.stringToInts2("[]");
        int[] quiet = {0};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution851.loudAndRich(richer, quiet));
    }
}
