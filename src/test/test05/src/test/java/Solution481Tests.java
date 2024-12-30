import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution481Tests {
    private final Solution481 solution481 = new Solution481();

    @Test
    public void example1() {
        int n = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution481.magicalString(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution481.magicalString(n));
    }
}