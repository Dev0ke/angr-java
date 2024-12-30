import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2310Tests {
    private final Solution2310 solution2310 = new Solution2310();

    @Test
    public void example1() {
        int num = 58;
        int k = 9;
        int expected = 2;
        Assertions.assertEquals(expected, solution2310.minimumNumbers(num, k));
    }

    @Test
    public void example2() {
        int num = 37;
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution2310.minimumNumbers(num, k));
    }

    @Test
    public void example3() {
        int num = 0;
        int k = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution2310.minimumNumbers(num, k));
    }
}
