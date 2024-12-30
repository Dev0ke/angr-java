import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution520Tests {
    private final Solution520 solution520 = new Solution520();

    @Test
    public void example1() {
        String word = "USA";
        Assertions.assertTrue(solution520.detectCapitalUse(word));
    }

    @Test
    public void example2() {
        String word = "FlaG";
        Assertions.assertFalse(solution520.detectCapitalUse(word));
    }
}
