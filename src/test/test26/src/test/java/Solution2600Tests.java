import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2600Tests {
    private final Solution2600 solution2600 = new Solution2600();

    @Test
    public void example1() {
        int numOnes = 3;
        int numZeros = 2;
        int numNegOnes = 0;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2600.kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }

    @Test
    public void example2() {
        int numOnes = 3;
        int numZeros = 2;
        int numNegOnes = 0;
        int k = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution2600.kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }
}