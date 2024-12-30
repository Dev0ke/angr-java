import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP408Tests {
    private final SolutionP408 solutionP408 = new SolutionP408();

    @Test
    public void example1() {
        String word = "internationalization";
        String abbr = "i12iz4n";
        Assertions.assertTrue(solutionP408.validWordAbbreviation(word, abbr));
    }

    @Test
    public void example2() {
        String word = "apple";
        String abbr = "a2e";
        Assertions.assertFalse(solutionP408.validWordAbbreviation(word, abbr));
    }

    // 补充用例
    @Test
    public void example3() {
        String word = "internationalization";
        String abbr = "i5a11o1";
        Assertions.assertTrue(solutionP408.validWordAbbreviation(word, abbr));
    }

    @Test
    public void example4() {
        String word = "a";
        String abbr = "01";
        Assertions.assertFalse(solutionP408.validWordAbbreviation(word, abbr));
    }

    @Test
    public void example5() {
        String word = "hi";
        String abbr = "2i";
        Assertions.assertFalse(solutionP408.validWordAbbreviation(word, abbr));
    }

    @Test
    public void example6() {
        String word = "word";
        String abbr = "3e";
        Assertions.assertFalse(solutionP408.validWordAbbreviation(word, abbr));
    }
}