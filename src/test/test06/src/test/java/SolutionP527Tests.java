import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP527Tests {
    private final SolutionP527 solutionP527 = new SolutionP527();

    @Test
    public void example1() {
        List<String> words = List.of("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion");
        List<String> expected = List.of("l2e", "god", "internal", "me", "i6t", "interval", "inte4n", "f2e", "intr4n");
        Assertions.assertEquals(expected, solutionP527.wordsAbbreviation(words));
    }

    @Test
    public void example2() {
        List<String> words = List.of("aa", "aaa");
        List<String> expected = List.of("aa", "aaa");
        Assertions.assertEquals(expected, solutionP527.wordsAbbreviation(words));
    }
}