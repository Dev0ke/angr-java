import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution950Tests {
    private final Solution950 solution950 = new Solution950();

    @Test
    public void example1() {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] expected = {2, 13, 3, 11, 5, 17, 7};
        Assertions.assertArrayEquals(expected, solution950.deckRevealedIncreasing(deck));
    }
}