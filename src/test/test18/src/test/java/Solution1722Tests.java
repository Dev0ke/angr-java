import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1722Tests {
    private final Solution1722 solution1722 = new Solution1722();

    @Test
    public void example1() {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = UtUtils.stringToInts2("[[0,1],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1722.minimumHammingDistance(source, target, allowedSwaps));
    }

    @Test
    public void example2() {
        int[] source = {1, 2, 3, 4};
        int[] target = {1, 3, 2, 4};
        int[][] allowedSwaps = UtUtils.stringToInts2("[]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1722.minimumHammingDistance(source, target, allowedSwaps));
    }

    @Test
    public void example3() {
        int[] source = {5, 1, 2, 4, 3};
        int[] target = {1, 5, 4, 2, 3};
        int[][] allowedSwaps = UtUtils.stringToInts2("[[0,4],[4,2],[1,3],[1,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1722.minimumHammingDistance(source, target, allowedSwaps));
    }
}