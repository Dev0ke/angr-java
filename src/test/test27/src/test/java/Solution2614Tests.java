import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2614Tests {
    private final Solution2614 solution2614 = new Solution2614();

    @Test
    public void example1() {
        int[][] nums = UtUtils.stringToInts2("[[1,2,3],[5,6,7],[9,10,11]]");
        int expected = 11;
        Assertions.assertEquals(expected, solution2614.diagonalPrime(nums));
    }

    @Test
    public void example2() {
        int[][] nums = UtUtils.stringToInts2("[[1,2,3],[5,17,7],[9,11,10]]");
        int expected = 17;
        Assertions.assertEquals(expected, solution2614.diagonalPrime(nums));
    }
}