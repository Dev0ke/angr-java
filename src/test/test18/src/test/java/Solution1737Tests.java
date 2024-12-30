import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1737Tests {
    private final Solution1737 solution1737 = new Solution1737();

    @Test
    public void example1() {
        String a = "aba";
        String b = "caa";
        int expected = 2;
        Assertions.assertEquals(expected, solution1737.minCharacters(a, b));
    }

    @Test
    public void example2() {
        String a = "dabadd";
        String b = "cda";
        int expected = 3;
        Assertions.assertEquals(expected, solution1737.minCharacters(a, b));
    }
}