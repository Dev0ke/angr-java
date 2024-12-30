import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution823Tests {
    private final Solution823 solution823 = new Solution823();

    @Test
    public void example1() {
        int[] arr = {2, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution823.numFactoredBinaryTrees(arr));
    }

    @Test
    public void example2() {
        int[] arr = {2, 4, 5, 10};
        int expected = 7;
        Assertions.assertEquals(expected, solution823.numFactoredBinaryTrees(arr));
    }
}