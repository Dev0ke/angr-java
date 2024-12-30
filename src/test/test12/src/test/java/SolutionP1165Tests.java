import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1165Tests {
    private final SolutionP1165 solutionP1165 = new SolutionP1165();

    @Test
    public void example1() {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1165.calculateTime(keyboard, word));
    }

    @Test
    public void example2() {
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "leetcode";
        int expected = 73;
        Assertions.assertEquals(expected, solutionP1165.calculateTime(keyboard, word));
    }
}