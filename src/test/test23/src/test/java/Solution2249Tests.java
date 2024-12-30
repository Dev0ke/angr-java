import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2249Tests {
    private final Solution2249 solution2249 = new Solution2249();

    @Test
    public void example1() {
        int[][] circles = UtUtils.stringToInts2("[[2,2,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution2249.countLatticePoints(circles));
    }

    @Test
    public void example2() {
        int[][] circles = UtUtils.stringToInts2("[[2,2,2],[3,4,1]]");
        int expected = 16;
        Assertions.assertEquals(expected, solution2249.countLatticePoints(circles));
    }
}
