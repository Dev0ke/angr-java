import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1181Tests {
    private final SolutionP1181 solutionP1181 = new SolutionP1181();

    @Test
    public void example1() {
        String[] phrases = {"writing code", "code rocks"};
        List<String> expected = List.of("writing code rocks");
        Assertions.assertEquals(expected, solutionP1181.beforeAndAfterPuzzles(phrases));
    }

    @Test
    public void example2() {
        String[] phrases = {"mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"};
        List<String> expected = List.of("a chip off the old block party",
                "a man on a mission impossible",
                "a man on a mission statement",
                "a quick bite to eat my words",
                "chocolate bar of soap");
        Assertions.assertEquals(expected, solutionP1181.beforeAndAfterPuzzles(phrases));
    }

    @Test
    public void example3() {
        String[] phrases = {"a", "b", "a"};
        List<String> expected = List.of("a");
        Assertions.assertEquals(expected, solutionP1181.beforeAndAfterPuzzles(phrases));
    }
}