import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution717Tests {
    private final Solution717 solution717 = new Solution717();

    @Test
    public void example1() {
        int[] bits = {1, 0, 0};
        Assertions.assertTrue(solution717.isOneBitCharacter(bits));
    }

    @Test
    public void example2() {
        int[] bits = {1, 1, 1, 0};
        Assertions.assertFalse(solution717.isOneBitCharacter(bits));
    }
}
