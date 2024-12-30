import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution424Tests {
    private final Solution424 solution424 = new Solution424();

    @Test
    public void example1() {
        String s = "ABAB";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution424.characterReplacement(s, k));
    }

    @Test
    public void example2() {
        String s = "AABABBA";
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution424.characterReplacement(s, k));
    }
}
