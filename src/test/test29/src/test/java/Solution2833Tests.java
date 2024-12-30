import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2833Tests {
    private final Solution2833 solution2833 = new Solution2833();

    @Test
    public void example1() {
        String moves = "L_RL__R";
        int expected = 3;
        Assertions.assertEquals(expected, solution2833.furthestDistanceFromOrigin(moves));
    }

    @Test
    public void example2() {
        String moves = "_R__LL_";
        int expected = 5;
        Assertions.assertEquals(expected, solution2833.furthestDistanceFromOrigin(moves));
    }

    @Test
    public void example3() {
        String moves = "_______";
        int expected = 7;
        Assertions.assertEquals(expected, solution2833.furthestDistanceFromOrigin(moves));
    }
}