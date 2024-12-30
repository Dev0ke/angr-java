import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1545Tests {
    private final Solution1545 solution1545 = new Solution1545();

    @Test
    public void example1() {
        int n = 3;
        int k = 1;
        char expected = '0';
        Assertions.assertEquals(expected, solution1545.findKthBit(n, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int k = 11;
        char expected = '1';
        Assertions.assertEquals(expected, solution1545.findKthBit(n, k));
    }

    @Test
    public void example3() {
        int n = 1;
        int k = 1;
        char expected = '0';
        Assertions.assertEquals(expected, solution1545.findKthBit(n, k));
    }

    @Test
    public void example4() {
        int n = 2;
        int k = 3;
        char expected = '1';
        Assertions.assertEquals(expected, solution1545.findKthBit(n, k));
    }
}
