import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3044Tests {
    private final Solution3044 solution3044 = new Solution3044();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,1],[9,9],[1,1]]");
        int expected = 19;
        Assertions.assertEquals(expected, solution3044.mostFrequentPrime(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[7]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3044.mostFrequentPrime(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[9,7,8],[4,6,5],[2,8,6]]");
        int expected = 97;
        Assertions.assertEquals(expected, solution3044.mostFrequentPrime(mat));
    }
}