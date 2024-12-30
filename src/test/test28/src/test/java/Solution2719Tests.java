import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2719Tests {
    private final Solution2719 solution2719 = new Solution2719();

    @Test
    public void example1() {
        String num1 = "1";
        String num2 = "12";
        int min_sum = 1;
        int max_sum = 8;
        int expected = 11;
        Assertions.assertEquals(expected, solution2719.count(num1, num2, min_sum, max_sum));
    }

    @Test
    public void example2() {
        String num1 = "1";
        String num2 = "5";
        int min_sum = 1;
        int max_sum = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution2719.count(num1, num2, min_sum, max_sum));
    }
}