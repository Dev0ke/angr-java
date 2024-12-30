import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP616Tests {
    private final SolutionP616 solutionP616 = new SolutionP616();

    @Test
    public void example1() {
        String s = "abcxyz123";
        String[] words = {"abc", "123"};
        String expected = "<b>abc</b>xyz<b>123</b>";
        Assertions.assertEquals(expected, solutionP616.addBoldTag(s, words));
    }

    @Test
    public void example2() {
        String s = "aaabbcc";
        String[] words = {"aaa", "aab", "bc"};
        String expected = "<b>aaabbc</b>c";
        Assertions.assertEquals(expected, solutionP616.addBoldTag(s, words));
    }
}
