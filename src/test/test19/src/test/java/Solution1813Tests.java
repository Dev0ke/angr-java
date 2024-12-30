import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1813Tests {
    private final Solution1813 solution1813 = new Solution1813();

    @Test
    public void example1() {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        Assertions.assertTrue(solution1813.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    public void example2() {
        String sentence1 = "of";
        String sentence2 = "A lot of words";
        Assertions.assertFalse(solution1813.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    public void example3() {
        String sentence1 = "Eating right now";
        String sentence2 = "Eating";
        Assertions.assertTrue(solution1813.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    public void example4() {
        String sentence1 = "Luky";
        String sentence2 = "Lucccky";
        Assertions.assertFalse(solution1813.areSentencesSimilar(sentence1, sentence2));
    }
}