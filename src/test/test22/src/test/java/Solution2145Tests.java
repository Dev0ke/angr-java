import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2145Tests {
    private final Solution2145 solution2145 = new Solution2145();

    @Test
    public void example1() {
        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution2145.numberOfArrays(differences, lower, upper));
    }

    @Test
    public void example2() {
        int[] differences = {3, -4, 5, 1, -2};
        int lower = -4;
        int upper = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution2145.numberOfArrays(differences, lower, upper));
    }

    @Test
    public void example3() {
        int[] differences = {4, -7, 2};
        int lower = 3;
        int upper = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solution2145.numberOfArrays(differences, lower, upper));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] differences = UtUtils.loadingInts("solution2145-example4-input.txt", 0);
        int lower = UtUtils.loadingInt("solution2145-example4-input.txt", 1);
        int upper = UtUtils.loadingInt("solution2145-example4-input.txt", 2);
        int expected = 0;
        Assertions.assertEquals(expected, solution2145.numberOfArrays(differences, lower, upper));
    }
}
