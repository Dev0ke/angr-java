import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6Tests {
    private final Solution6 solution6 = new Solution6();

    @Test
    public void example1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        Assertions.assertEquals(expected, solution6.convert(s, numRows));
    }

    @Test
    public void example2() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        Assertions.assertEquals(expected, solution6.convert(s, numRows));
    }

    @Test
    public void example3() {
        String s = "A";
        int numRows = 1;
        String expected = "A";
        Assertions.assertEquals(expected, solution6.convert(s, numRows));
    }
}
