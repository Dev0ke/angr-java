import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2024Tests {
    private final Solution2024 solution2024 = new Solution2024();

    @Test
    public void example1() {
        String answerKey = "TTFF";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2024.maxConsecutiveAnswers(answerKey, k));
    }

    @Test
    public void example2() {
        String answerKey = "TFFT";
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution2024.maxConsecutiveAnswers(answerKey, k));
    }

    @Test
    public void example3() {
        String answerKey = "TTFTTFTT";
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution2024.maxConsecutiveAnswers(answerKey, k));
    }
}
