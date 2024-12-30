import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2423Tests {
    private final Solution2423 solution2423 = new Solution2423();

    @Test
    public void example1() {
        String word = "abcc";
        Assertions.assertTrue(solution2423.equalFrequency(word));
    }

    @Test
    public void example2() {
        String word = "aazz";
        Assertions.assertFalse(solution2423.equalFrequency(word));
    }
}
