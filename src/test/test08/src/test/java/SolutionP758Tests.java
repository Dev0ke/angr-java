import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP758Tests {
    private final SolutionP758 solutionP758 = new SolutionP758();

    @Test
    public void example1() {
        String[] words = {"ab", "bc"};
        String s = "aabcd";
        String expected = "a<b>abc</b>d";
        Assertions.assertEquals(expected, solutionP758.boldWords(words, s));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "cb"};
        String s = "aabcd";
        String expected = "a<b>ab</b>cd";
        Assertions.assertEquals(expected, solutionP758.boldWords(words, s));
    }
}
