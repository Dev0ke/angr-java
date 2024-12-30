import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution799Tests {
    private final Solution799 solution799 = new Solution799();

    @Test
    public void example1() {
        int poured = 1;
        int query_row = 1;
        int query_glass = 1;
        double expected = 0.00000;
        Assertions.assertEquals(expected, solution799.champagneTower(poured, query_row, query_glass));
    }

    @Test
    public void example2() {
        int poured = 2;
        int query_row = 1;
        int query_glass = 1;
        double expected = 0.50000;
        Assertions.assertEquals(expected, solution799.champagneTower(poured, query_row, query_glass));
    }

    @Test
    public void example3() {
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution799.champagneTower(poured, query_row, query_glass));
    }
}