import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2022Tests {
    private final Solution2022 solution2022 = new Solution2022();

    @Test
    public void example1() {
        int[] original = {1, 2, 3, 4};
        int m = 2, n = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,2],[3,4]]");
        Assertions.assertArrayEquals(expected, solution2022.construct2DArray(original, m, n));
    }

    @Test
    public void example2() {
        int[] original = {1, 2, 3};
        int m = 1, n = 3;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3]]");
        Assertions.assertArrayEquals(expected, solution2022.construct2DArray(original, m, n));
    }

    @Test
    public void example3() {
        int[] original = {1, 2};
        int m = 1, n = 1;
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution2022.construct2DArray(original, m, n));
    }

    @Test
    public void example4() {
        int[] original = {3};
        int m = 1, n = 2;
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution2022.construct2DArray(original, m, n));
    }
}

