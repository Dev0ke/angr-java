import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2975Tests {
    private final Solution2975 solution2975 = new Solution2975();

    @Test
    public void example1() {
        int m = 4;
        int n = 3;
        int[] hFences = {2, 3};
        int[] vFences = {2};
        int expected = 4;
        Assertions.assertEquals(expected, solution2975.maximizeSquareArea(m, n, hFences, vFences));
    }

    @Test
    public void example2() {
        int m = 6;
        int n = 7;
        int[] hFences = {2};
        int[] vFences = {4};
        int expected = -1;
        Assertions.assertEquals(expected, solution2975.maximizeSquareArea(m, n, hFences, vFences));
    }
}