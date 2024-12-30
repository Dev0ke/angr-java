import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP311Tests {
    private final SolutionP311 solutionP311 = new SolutionP311();

    @Test
    public void example1() {
        int[][] mat1 = UtUtils.stringToInts2("[[1,0,0],[-1,0,3]]");
        int[][] mat2 = UtUtils.stringToInts2("[[7,0,0],[0,0,0],[0,0,1]]");
        int[][] expected = UtUtils.stringToInts2("[[7,0,0],[-7,0,3]]");
        Assertions.assertArrayEquals(expected, solutionP311.multiply(mat1, mat2));
    }

    @Test
    public void example2() {
        int[][] mat1 = UtUtils.stringToInts2("[[0]]");
        int[][] mat2 = UtUtils.stringToInts2("[[0]]");
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        Assertions.assertArrayEquals(expected, solutionP311.multiply(mat1, mat2));
    }
}
