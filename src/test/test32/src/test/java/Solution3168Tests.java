import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3168Tests {
    private final Solution3168 solution3168 = new Solution3168();

    @Test
    public void example1() {
        String s = "EEEEEEE";
        int expected = 7;
        Assertions.assertEquals(expected, solution3168.minimumChairs(s));
    }

    @Test
    public void example2() {
        String s = "ELELEEL";
        int expected = 2;
        Assertions.assertEquals(expected, solution3168.minimumChairs(s));
    }

    @Test
    public void example3() {
        String s = "ELEELEELLL";
        int expected = 3;
        Assertions.assertEquals(expected, solution3168.minimumChairs(s));
    }
}