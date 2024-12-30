import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2819Tests {
    private final SolutionP2819 solutionP2819 = new SolutionP2819();

    @Test
    public void example1() {
        int[] prices = {1, 9, 22, 10, 19};
        int[][] queries = UtUtils.stringToInts2("[[18,4],[5,2]]");
        long[] expected = {34, -21};
        Assertions.assertArrayEquals(expected, solutionP2819.minimumRelativeLosses(prices, queries));
    }

    @Test
    public void example2() {
        int[] prices = {1, 5, 4, 3, 7, 11, 9};
        int[][] queries = UtUtils.stringToInts2("[[5,4],[5,7],[7,3],[4,5]]");
        long[] expected = {4, 16, 7, 1};
        Assertions.assertArrayEquals(expected, solutionP2819.minimumRelativeLosses(prices, queries));
    }

    @Test
    public void example3() {
        int[] prices = {5, 6, 7};
        int[][] queries = UtUtils.stringToInts2("[[10,1],[5,3],[3,3]]");
        long[] expected = {5, 12, 0};
        Assertions.assertArrayEquals(expected, solutionP2819.minimumRelativeLosses(prices, queries));
    }
}