import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1710Tests {
    private final Solution1710 solution1710 = new Solution1710();

    @Test
    public void example1() {
        int[][] boxTypes = UtUtils.stringToInts2("[[1,3],[2,2],[3,1]]");
        int truckSize = 4;
        int expected = 8;
        Assertions.assertEquals(expected, solution1710.maximumUnits(boxTypes, truckSize));
    }

    @Test
    public void example2() {
        int[][] boxTypes = UtUtils.stringToInts2("[[5,10],[2,5],[4,7],[3,9]]");
        int truckSize = 10;
        int expected = 91;
        Assertions.assertEquals(expected, solution1710.maximumUnits(boxTypes, truckSize));
    }
}
