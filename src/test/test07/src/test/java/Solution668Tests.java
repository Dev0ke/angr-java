import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution668Tests {
    private final Solution668 solution668 = new Solution668();

    @Test
    public void example1() {
        int m = 3;
        int n = 3;
        int k = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solution668.findKthNumber(m, n, k));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 3;
        int k = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution668.findKthNumber(m, n, k));
    }
}
