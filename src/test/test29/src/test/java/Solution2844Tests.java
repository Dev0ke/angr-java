import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2844Tests {
    private final Solution2844 solution2844 = new Solution2844();

    @Test
    public void example1() {
        String num = "2245047";
        int expected = 2;
        Assertions.assertEquals(expected, solution2844.minimumOperations(num));
    }

    @Test
    public void example2() {
        String num = "2908305";
        int expected = 3;
        Assertions.assertEquals(expected, solution2844.minimumOperations(num));
    }

    @Test
    public void example3() {
        String num = "10";
        int expected = 1;
        Assertions.assertEquals(expected, solution2844.minimumOperations(num));
    }
}