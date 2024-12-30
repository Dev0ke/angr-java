import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution67Tests {
    private final Solution67 solution67 = new Solution67();

    @Test
    public void example1() {
        String a = "11";
        String b = "10";
        String expected = "101";
        Assertions.assertEquals(expected, solution67.addBinary(a, b));
    }

    @Test
    public void example2() {
        String a = "1010";
        String b = "1011";
        String expected = "10101";
        Assertions.assertEquals(expected, solution67.addBinary(a, b));
    }
}
