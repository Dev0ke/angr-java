import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP723Tests {
    private final SolutionP723 solutionP723 = new SolutionP723();

    @Test
    public void example1() {
        int[][] board = UtUtils.stringToInts2("[[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]");
        Assertions.assertArrayEquals(expected, solutionP723.candyCrush(board));
    }

    @Test
    public void example2() {
        int[][] board = UtUtils.stringToInts2("[[1,3,5,5,2],[3,4,3,3,1],[3,2,4,5,2],[2,4,4,5,5],[1,4,4,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,3,0,0,0],[3,4,0,5,2],[3,2,0,3,1],[2,4,0,5,2],[1,4,3,1,1]]");
        Assertions.assertArrayEquals(expected, solutionP723.candyCrush(board));
    }
}