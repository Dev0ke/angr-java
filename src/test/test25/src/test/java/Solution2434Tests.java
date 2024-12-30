import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2434Tests {
    private final Solution2434 solution2434 = new Solution2434();

    @Test
    public void example1() {
        String s = "zza";
        String expected = "azz";
        Assertions.assertEquals(expected, solution2434.robotWithString(s));
    }

    @Test
    public void example2() {
        String s = "bac";
        String expected = "abc";
        Assertions.assertEquals(expected, solution2434.robotWithString(s));
    }

    @Test
    public void example3() {
        String s = "bdda";
        String expected = "addb";
        Assertions.assertEquals(expected, solution2434.robotWithString(s));
    }
}
