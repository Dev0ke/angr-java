import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution804Tests {
    private final Solution804 solution804 = new Solution804();

    @Test
    public void example1() {
        String[] words = {"gin", "zen", "gig", "msg"};
        int expected = 2;
        Assertions.assertEquals(expected, solution804.uniqueMorseRepresentations(words));
    }

    @Test
    public void example2() {
        String[] words = {"a"};
        int expected = 1;
        Assertions.assertEquals(expected, solution804.uniqueMorseRepresentations(words));
    }
}
