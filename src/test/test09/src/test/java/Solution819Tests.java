import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution819Tests {
    private final Solution819 solution819 = new Solution819();

    @Test
    public void example1() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        String expected = "ball";
        Assertions.assertEquals(expected, solution819.mostCommonWord(paragraph, banned));
    }
}
