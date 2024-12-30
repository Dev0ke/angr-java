import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2496Tests {
    private final Solution2496 solution2496 = new Solution2496();

    @Test
    public void example1() {
        String[] strs = {"alic3", "bob", "3", "4", "00000"};
        int expected = 5;
        Assertions.assertEquals(expected, solution2496.maximumValue(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"1", "01", "001", "0001"};
        int expected = 1;
        Assertions.assertEquals(expected, solution2496.maximumValue(strs));
    }
}
