import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2801Tests {
    private final Solution2801 solution2801 = new Solution2801();

    @Test
    public void example1() {
        String low = "1";
        String high = "11";
        int expected = 10;
        Assertions.assertEquals(expected, solution2801.countSteppingNumbers(low, high));
    }

    @Test
    public void example2() {
        String low = "90";
        String high = "101";
        int expected = 2;
        Assertions.assertEquals(expected, solution2801.countSteppingNumbers(low, high));
    }
}