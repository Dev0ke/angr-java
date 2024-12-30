import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution190Tests {
    private final Solution190 solution190 = new Solution190();

    @Test
    public void example1() {
        int n = 0b00000010100101000001111010011100;
        int expected = 964176192;
        Assertions.assertEquals(expected, solution190.reverseBits(n));
    }

    @Test
    public void example2() {
        int n = 0b11111111111111111111111111111101;
        int expected = -1073741825;
        Assertions.assertEquals(expected, solution190.reverseBits(n));
    }
}
