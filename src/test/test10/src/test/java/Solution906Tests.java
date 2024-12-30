import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution906Tests {
    private final Solution906 solution906 = new Solution906();

    @Test
    public void example1() {
        String left = "4";
        String right = "1000";
        int expected = 4;
        Assertions.assertEquals(expected, solution906.superpalindromesInRange(left, right));
    }
}
