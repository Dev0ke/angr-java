import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3147Tests {
    private final Solution3147 solution3147 = new Solution3147();

    @Test
    public void example1() {
        int[] energy = {5, 2, -10, -5, 1};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3147.maximumEnergy(energy, k));
    }

    @Test
    public void example2() {
        int[] energy = {-2, -3, -1};
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3147.maximumEnergy(energy, k));
    }
}