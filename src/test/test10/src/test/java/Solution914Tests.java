import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution914Tests {
    private final Solution914 solution914 = new Solution914();

    @Test
    public void example1() {
        int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        Assertions.assertTrue(solution914.hasGroupsSizeX(deck));
    }

    @Test
    public void example2() {
        int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
        Assertions.assertFalse(solution914.hasGroupsSizeX(deck));
    }

    @Test
    public void example3() {
        int[] deck = {1};
        Assertions.assertFalse(solution914.hasGroupsSizeX(deck));
    }

    @Test
    public void example4() {
        int[] deck = {1, 1};
        Assertions.assertTrue(solution914.hasGroupsSizeX(deck));
    }

    @Test
    public void example5() {
        int[] deck = {1, 1, 2, 2, 2, 2};
        Assertions.assertTrue(solution914.hasGroupsSizeX(deck));
    }
}
