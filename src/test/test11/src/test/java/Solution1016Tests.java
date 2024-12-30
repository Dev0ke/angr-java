import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1016Tests {
    private final Solution1016 solution1016 = new Solution1016();

    @Test
    public void example1() {
        String s = "0110";
        int n = 3;
        Assertions.assertTrue(solution1016.queryString(s, n));
    }

    @Test
    public void example2() {
        String s = "0110";
        int n = 4;
        Assertions.assertFalse(solution1016.queryString(s, n));
    }
}