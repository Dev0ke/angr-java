import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution956Tests {
    private final Solution956 solution956 = new Solution956();
    private final Solution956.V2 solution956_v2 = new Solution956.V2();

    @Test
    public void example1() {
        int[] rods = {1, 2, 3, 6};
        int expected = 6;
        Assertions.assertEquals(expected, solution956.tallestBillboard(rods));
        Assertions.assertEquals(expected, solution956_v2.tallestBillboard(rods));
    }

    @Test
    public void example2() {
        int[] rods = {1, 2, 3, 4, 5, 6};
        int expected = 10;
        Assertions.assertEquals(expected, solution956.tallestBillboard(rods));
        Assertions.assertEquals(expected, solution956_v2.tallestBillboard(rods));
    }

    @Test
    public void example3() {
        int[] rods = {1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution956.tallestBillboard(rods));
        Assertions.assertEquals(expected, solution956_v2.tallestBillboard(rods));
    }
}