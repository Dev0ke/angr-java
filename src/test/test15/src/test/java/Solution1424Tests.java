import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1424Tests {
    private final Solution1424 solution1424 = new Solution1424();

    @Test
    public void example1() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] expected = {1, 4, 2, 7, 5, 3, 8, 6, 9};
        Assertions.assertArrayEquals(expected, solution1424.findDiagonalOrder(nums));
    }

    @Test
    public void example2() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]");
        int[] expected = {1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16};
        Assertions.assertArrayEquals(expected, solution1424.findDiagonalOrder(nums));
    }

    @Test
    public void example3() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[1,2,3],[4],[5,6,7],[8],[9,10,11]]");
        int[] expected = {1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11};
        Assertions.assertArrayEquals(expected, solution1424.findDiagonalOrder(nums));
    }

    @Test
    public void example4() {
        List<List<Integer>> nums = UtUtils.stringToIntegerList2("[[1,2,3,4,5,6]]");
        int[] expected = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expected, solution1424.findDiagonalOrder(nums));
    }
}