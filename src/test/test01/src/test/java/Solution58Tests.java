import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution58Tests {
    private final Solution58 solution58 = new Solution58();

    @Test
    public void example1() {
        String s = "Hello World";
        int expected = 5;
        Assertions.assertEquals(expected, solution58.lengthOfLastWord(s));
    }

    @Test
    public void example2() {
        String s = "   fly me   to   the moon  ";
        int expected = 4;
        Assertions.assertEquals(expected, solution58.lengthOfLastWord(s));
    }

    @Test
    public void example3() {
        String s = "luffy is still joyboy";
        int expected = 6;
        Assertions.assertEquals(expected, solution58.lengthOfLastWord(s));
    }
}
