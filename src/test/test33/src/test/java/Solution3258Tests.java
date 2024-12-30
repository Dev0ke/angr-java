import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3258Tests {
    private final Solution3258 solution3258 = new Solution3258();

    @Test
    public void example1() {
        String s = "10101";
        int k = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution3258.countKConstraintSubstrings(s, k));
    }

    @Test
    public void example2() {
        String s = "1010101";
        int k = 2;
        int expected = 25;
        Assertions.assertEquals(expected, solution3258.countKConstraintSubstrings(s, k));
    }

    @Test
    public void example3() {
        String s = "11111";
        int k = 1;
        int expected = 15;
        Assertions.assertEquals(expected, solution3258.countKConstraintSubstrings(s, k));
    }
}