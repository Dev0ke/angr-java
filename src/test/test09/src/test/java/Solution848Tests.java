import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution848Tests {
    private final Solution848 solution848 = new Solution848();

    @Test
    public void example1() {
        String s = "abc";
        int[] shifts = {3, 5, 9};
        String expected = "rpl";
        Assertions.assertEquals(expected, solution848.shiftingLetters(s, shifts));
    }
}
