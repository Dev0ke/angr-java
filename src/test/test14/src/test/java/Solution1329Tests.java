import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1329Tests {
    private final Solution1329 solution1329 = new Solution1329();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[3,3,1,1],[2,2,1,2],[1,1,1,2]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,1,1],[1,2,2,2],[1,2,3,3]]");
        Assertions.assertArrayEquals(expected, solution1329.diagonalSort(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]");
        int[][] expected = UtUtils.stringToInts2("[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]");
        Assertions.assertArrayEquals(expected, solution1329.diagonalSort(mat));
    }
}