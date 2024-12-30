import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1428Tests {
    static class BinaryMatrixImpl implements SolutionP1428.BinaryMatrix {
        int[][] mat;
        int m;
        int n;

        public BinaryMatrixImpl(int[][] mat) {
            this.mat = mat;
            m = mat.length;
            n = mat[0].length;
        }

        @Override
        public int get(int row, int col) {
            return mat[row][col];
        }

        @Override
        public List<Integer> dimensions() {
            return List.of(m, n);
        }
    }

    private final SolutionP1428 solutionP1428 = new SolutionP1428();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[1,1]]");
        SolutionP1428.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(mat);
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1428.leftMostColumnWithOne(binaryMatrix));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[0,1]]");
        SolutionP1428.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(mat);
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1428.leftMostColumnWithOne(binaryMatrix));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[0,0]]");
        SolutionP1428.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(mat);
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1428.leftMostColumnWithOne(binaryMatrix));
    }

    @Test
    public void example4() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0,1],[0,0,1,1],[0,1,1,1]]");
        SolutionP1428.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(mat);
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1428.leftMostColumnWithOne(binaryMatrix));
    }
}
