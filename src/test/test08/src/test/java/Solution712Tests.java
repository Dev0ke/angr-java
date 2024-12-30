import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution712Tests {
    private final Solution712 solution712 = new Solution712();

    @Test
    public void example1() {
        String s1 = "sea";
        String s2 = "eat";
        int expected = 231;
        Assertions.assertEquals(expected, solution712.minimumDeleteSum(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "delete";
        String s2 = "leet";
        int expected = 403;
        Assertions.assertEquals(expected, solution712.minimumDeleteSum(s1, s2));
    }
}
