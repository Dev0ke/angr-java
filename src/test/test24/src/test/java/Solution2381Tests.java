import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2381Tests {
    private final Solution2381 solution2381 = new Solution2381();

    @Test
    public void example1() {
        String s = "abc";
        int[][] shifts = UtUtils.stringToInts2("[[0,1,0],[1,2,1],[0,2,1]]");
        String expected = "ace";
        Assertions.assertEquals(expected, solution2381.shiftingLetters(s, shifts));
    }

    @Test
    public void example2() {
        String s = "dztz";
        int[][] shifts = UtUtils.stringToInts2("[[0,0,0],[1,1,1]]");
        String expected = "catz";
        Assertions.assertEquals(expected, solution2381.shiftingLetters(s, shifts));
    }
}
