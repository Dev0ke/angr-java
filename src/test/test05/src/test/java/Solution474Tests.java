import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution474Tests {
    private final Solution474 solution474 = new Solution474();

    @Test
    public void example1() {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution474.findMaxForm(strs, m, n));
    }

    @Test
    public void example2() {
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution474.findMaxForm(strs, m, n));
    }
}
