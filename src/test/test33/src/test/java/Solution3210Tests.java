import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3210Tests {
    private final Solution3210 solution3210 = new Solution3210();

    @Test
    public void example1() {
        String s = "dart";
        int k = 3;
        String expected = "tdar";
        Assertions.assertEquals(expected, solution3210.getEncryptedString(s, k));
    }

    @Test
    public void example2() {
        String s = "aaa";
        int k = 1;
        String expected = "aaa";
        Assertions.assertEquals(expected, solution3210.getEncryptedString(s, k));
    }
}