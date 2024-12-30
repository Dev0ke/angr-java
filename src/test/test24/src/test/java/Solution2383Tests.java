import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2383Tests {
    private final Solution2383 solution2383 = new Solution2383();

    @Test
    public void example1() {
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = {1, 4, 3, 2};
        int[] experience = {2, 6, 3, 1};
        int expected = 8;
        Assertions.assertEquals(expected, solution2383.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    @Test
    public void example2() {
        int initialEnergy = 2;
        int initialExperience = 4;
        int[] energy = {1};
        int[] experience = {3};
        int expected = 0;
        Assertions.assertEquals(expected, solution2383.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }
}
