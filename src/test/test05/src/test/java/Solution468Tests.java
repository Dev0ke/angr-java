import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution468Tests {
    private final Solution468 solution468 = new Solution468();

    @Test
    public void example1() {
        String queryIP = "172.16.254.1";
        String expected = "IPv4";
        Assertions.assertEquals(expected, solution468.validIPAddress(queryIP));
    }

    @Test
    public void example2() {
        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String expected = "IPv6";
        Assertions.assertEquals(expected, solution468.validIPAddress(queryIP));
    }

    @Test
    public void example3() {
        String queryIP = "256.256.256.256";
        String expected = "Neither";
        Assertions.assertEquals(expected, solution468.validIPAddress(queryIP));
    }
}
