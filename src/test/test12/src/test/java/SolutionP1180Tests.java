import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1180Tests {
    private final SolutionP1180 solutionP1180 = new SolutionP1180();

    @Test
    public void example1() {
        String s = "aaaba";
        int expected = 8;
        Assertions.assertEquals(expected, solutionP1180.countLetters(s));
    }

    @Test
    public void example2() {
        String s = "aaaaaaaaaa";
        int expected = 55;
        Assertions.assertEquals(expected, solutionP1180.countLetters(s));
    }
}