import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP422Tests {
    private final SolutionP422 solutionP422 = new SolutionP422();

    @Test
    public void example1() {
        List<String> words = List.of(
                "abcd",
                "bnrt",
                "crmy",
                "dtye");
        Assertions.assertTrue(solutionP422.validWordSquare(words));
    }

    @Test
    public void example2() {
        List<String> words = List.of(
                "abcd",
                "bnrt",
                "crm",
                "dt");
        Assertions.assertTrue(solutionP422.validWordSquare(words));
    }

    @Test
    public void example3() {
        List<String> words = List.of(
                "ball",
                "area",
                "read",
                "lady");
        Assertions.assertFalse(solutionP422.validWordSquare(words));
    }
}
