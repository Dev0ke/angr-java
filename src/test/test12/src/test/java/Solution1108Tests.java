import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1108Tests {
    private final Solution1108 solution1108 = new Solution1108();

    @Test
    public void example1() {
        String address = "1.1.1.1";
        String expected = "1[.]1[.]1[.]1";
        Assertions.assertEquals(expected, solution1108.defangIPaddr(address));
    }

    @Test
    public void example2() {
        String address = "255.100.50.0";
        String expected = "255[.]100[.]50[.]0";
        Assertions.assertEquals(expected, solution1108.defangIPaddr(address));
    }
}
