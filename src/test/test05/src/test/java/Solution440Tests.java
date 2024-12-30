import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution440Tests {
    private final Solution440 solution440 = new Solution440();

    @Test
    public void example1() {
        int n = 13;
        int k = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution440.findKthNumber(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution440.findKthNumber(n, k));
    }
}