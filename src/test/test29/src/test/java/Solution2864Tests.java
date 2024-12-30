import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2864Tests {
    private final Solution2864 solution2864 = new Solution2864();

    @Test
    public void example1() {
        String s = "010";
        String expected = "001";
        Assertions.assertEquals(expected, solution2864.maximumOddBinaryNumber(s));
    }

    @Test
    public void example2() {
        String s = "0101";
        String expected = "1001";
        Assertions.assertEquals(expected, solution2864.maximumOddBinaryNumber(s));
    }
}