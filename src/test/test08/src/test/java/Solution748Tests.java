import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution748Tests {
    private final Solution748 solution748 = new Solution748();

    @Test
    public void example1() {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        String expected = "steps";
        Assertions.assertEquals(expected, solution748.shortestCompletingWord(licensePlate, words));
    }

    @Test
    public void example2() {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        String expected = "pest";
        Assertions.assertEquals(expected, solution748.shortestCompletingWord(licensePlate, words));
    }

    @Test
    public void example3() {
        String licensePlate = "Ah71752";
        String[] words = {"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"};
        String expected = "husband";
        Assertions.assertEquals(expected, solution748.shortestCompletingWord(licensePlate, words));
    }

    @Test
    public void example4() {
        String licensePlate = "OgEu755";
        String[] words = {"enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"};
        String expected = "enough";
        Assertions.assertEquals(expected, solution748.shortestCompletingWord(licensePlate, words));
    }

    @Test
    public void example5() {
        String licensePlate = "iMSlpe4";
        String[] words = {"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"};
        String expected = "simple";
        Assertions.assertEquals(expected, solution748.shortestCompletingWord(licensePlate, words));
    }
}
