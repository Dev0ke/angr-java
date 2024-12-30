import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3144Tests {
    private final Solution3144 solution3144 = new Solution3144();

    @Test
    public void example1() {
        String s = "fabccddg";
        int expected = 3;
        Assertions.assertEquals(expected, solution3144.minimumSubstringsInPartition(s));
    }

    @Test
    public void example2() {
        String s = "abababaccddb";
        int expected = 2;
        Assertions.assertEquals(expected, solution3144.minimumSubstringsInPartition(s));
    }
}