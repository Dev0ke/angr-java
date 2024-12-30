import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1899Tests {
    private final Solution1899 solution1899 = new Solution1899();

    @Test
    public void example1() {
        int[][] triplets = UtUtils.stringToInts2("[[2,5,3],[1,8,4],[1,7,5]]");
        int[] target = {2, 7, 5};
        Assertions.assertTrue(solution1899.mergeTriplets(triplets, target));
    }

    @Test
    public void example2() {
        int[][] triplets = UtUtils.stringToInts2("[[1,3,4],[2,5,8]]");
        int[] target = {2, 5, 8};
        Assertions.assertTrue(solution1899.mergeTriplets(triplets, target));
    }

    @Test
    public void example3() {
        int[][] triplets = UtUtils.stringToInts2("[[2,5,3],[2,3,4],[1,2,5],[5,2,3]]");
        int[] target = {5, 5, 5};
        Assertions.assertTrue(solution1899.mergeTriplets(triplets, target));
    }

    @Test
    public void example4() {
        int[][] triplets = UtUtils.stringToInts2("[[3,4,5],[4,5,6]]");
        int[] target = {3, 2, 5};
        Assertions.assertFalse(solution1899.mergeTriplets(triplets, target));
    }
}