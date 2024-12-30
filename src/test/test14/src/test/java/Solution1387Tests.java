import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1387Tests {
    private final Solution1387 solution1387 = new Solution1387();

    @Test
    public void example1() {
        int lo = 12;
        int hi = 15;
        int k = 2;
        int expected = 13;
        Assertions.assertEquals(expected, solution1387.getKth(lo, hi, k));
    }

    @Test
    public void example2() {
        int lo = 7;
        int hi = 11;
        int k = 4;
        int expected = 7;
        Assertions.assertEquals(expected, solution1387.getKth(lo, hi, k));
    }
}