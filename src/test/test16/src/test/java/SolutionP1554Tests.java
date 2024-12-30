import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1554Tests {
    private final SolutionP1554 solutionP1554 = new SolutionP1554();

    @Test
    public void example1() {
        String[] dict = {"abcd", "acbd", "aacd"};
        Assertions.assertTrue(solutionP1554.differByOne(dict));
    }

    @Test
    public void example2() {
        String[] dict = {"ab", "cd", "yz"};
        Assertions.assertFalse(solutionP1554.differByOne(dict));
    }

    @Test
    public void example3() {
        String[] dict = {"abcd", "cccc", "abyd", "abab"};
        Assertions.assertTrue(solutionP1554.differByOne(dict));
    }
}