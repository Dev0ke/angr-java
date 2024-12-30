import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2052Tests {
    private final SolutionP2052 solutionP2052 = new SolutionP2052();

    @Test
    public void example1() {
        String sentence = "i love leetcode";
        int k = 12;
        int expected = 36;
        Assertions.assertEquals(expected, solutionP2052.minimumCost(sentence, k));
    }

    @Test
    public void example2() {
        String sentence = "apples and bananas taste great";
        int k = 7;
        int expected = 21;
        Assertions.assertEquals(expected, solutionP2052.minimumCost(sentence, k));
    }

    @Test
    public void example3() {
        String sentence = "a";
        int k = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2052.minimumCost(sentence, k));
    }
}