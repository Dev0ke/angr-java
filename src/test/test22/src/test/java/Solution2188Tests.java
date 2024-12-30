import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2188Tests {
    private final Solution2188 solution2188 = new Solution2188();

    @Test
    public void example1() {
        int[][] tires = UtUtils.stringToInts2("[[2,3],[3,4]]");
        int changeTime = 5;
        int numLaps = 4;
        int expected = 21;
        Assertions.assertEquals(expected, solution2188.minimumFinishTime(tires, changeTime, numLaps));
    }

    @Test
    public void example2() {
        int[][] tires = UtUtils.stringToInts2("[[1,10],[2,2],[3,4]]");
        int changeTime = 6;
        int numLaps = 5;
        int expected = 25;
        Assertions.assertEquals(expected, solution2188.minimumFinishTime(tires, changeTime, numLaps));
    }
}
