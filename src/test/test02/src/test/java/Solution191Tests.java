import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution191Tests {
    private final Solution191 solution191 = new Solution191();

    @Test
    public void example1() {
        int n = 0b00000000000000000000000000001011;
        int expected = 3;
        Assertions.assertEquals(expected, solution191.hammingWeight(n));
        Assertions.assertEquals(expected, solution191.hammingWeight2(n));
    }

    @Test
    public void example2() {
        int n = 0b00000000000000000000000010000000;
        int expected = 1;
        Assertions.assertEquals(expected, solution191.hammingWeight(n));
        Assertions.assertEquals(expected, solution191.hammingWeight2(n));
    }

    @Test
    public void example3() {
        int n = 0b11111111111111111111111111111101;
        int expected = 31;
        Assertions.assertEquals(expected, solution191.hammingWeight(n));
        Assertions.assertEquals(expected, solution191.hammingWeight2(n));
    }
}
