import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1837Tests {
    private final Solution1837 solution1837 = new Solution1837();

    @Test
    public void example1() {
        int n = 34;
        int k = 6;
        int expected = 9;
        Assertions.assertEquals(expected, solution1837.sumBase(n, k));
    }

    @Test
    public void example2() {
        int n = 10;
        int k = 10;
        int expected = 1;
        Assertions.assertEquals(expected, solution1837.sumBase(n, k));
    }
}
