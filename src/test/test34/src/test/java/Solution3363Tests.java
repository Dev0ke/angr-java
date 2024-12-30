import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3363Tests {
    private final Solution3363 solution3363 = new Solution3363();

    @Test
    public void example1() {
        int[][] fruits = UtUtils.stringToInts2("[[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]");
        int expected = 100;
        Assertions.assertEquals(expected, solution3363.maxCollectedFruits(fruits));
    }

    @Test
    public void example2() {
        int[][] fruits = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3363.maxCollectedFruits(fruits));
    }
}