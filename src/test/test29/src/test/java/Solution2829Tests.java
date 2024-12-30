import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2829Tests {
    private final Solution2829 solution2829 = new Solution2829();

    @Test
    public void example1() {
        int n = 5;
        int k = 4;
        int expected = 18;
        Assertions.assertEquals(expected, solution2829.minimumSum(n, k));
        Assertions.assertEquals(expected, solution2829.minimumSum2(n, k));
    }

    @Test
    public void example2() {
        int n = 2;
        int k = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution2829.minimumSum(n, k));
        Assertions.assertEquals(expected, solution2829.minimumSum2(n, k));
    }
}