import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP186Tests {
    private final SolutionP186 solutionP186 = new SolutionP186();

    @Test
    public void example1() {
        char[] s = UtUtils.stringToChars("""
                ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
                """);
        char[] expected = UtUtils.stringToChars("""
                ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
                """);
        solutionP186.reverseWords(s);
        Assertions.assertArrayEquals(expected, s);
    }

    @Test
    public void example2() {
        char[] s = UtUtils.stringToChars("""
                ["a"]
                """);
        char[] expected = UtUtils.stringToChars("""
                ["a"]
                 """);
        solutionP186.reverseWords(s);
        Assertions.assertArrayEquals(expected, s);
    }
}
