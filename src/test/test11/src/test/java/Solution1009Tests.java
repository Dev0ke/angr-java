import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1009Tests {
    private final Solution1009 solution1009 = new Solution1009();

    @Test
    public void example1() {
        int n = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1009.bitwiseComplement(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution1009.bitwiseComplement(n));
    }

    @Test
    public void example3() {
        int n = 10;
        int expected = 5;
        Assertions.assertEquals(expected, solution1009.bitwiseComplement(n));
    }
}
