import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionP320Tests {
    private final SolutionP320 solutionP320 = new SolutionP320();

    @Test
    public void example1() {
        String word = "word";
        List<String> expected = Arrays.asList("4", "3d", "2r1", "2rd", "1o2", "1o1d", "1or1", "1ord", "w3", "w2d", "w1r1", "w1rd", "wo2", "wo1d", "wor1", "word");
        List<String> actual = solutionP320.generateAbbreviations(word);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String word = "a";
        List<String> expected = Arrays.asList("1", "a");
        List<String> actual = solutionP320.generateAbbreviations(word);
        expected.sort(null);
        actual.sort(null);
        Assertions.assertEquals(expected, actual);
    }
}
