import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3207Tests {
    private final Solution3207 solution3207 = new Solution3207();

    @Test
    public void example1() {
        int[] enemyEnergies = {3, 2, 2};
        int currentEnergy = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution3207.maximumPoints(enemyEnergies, currentEnergy));
    }

    @Test
    public void example2() {
        int[] enemyEnergies = {2};
        int currentEnergy = 10;
        long expected = 5;
        Assertions.assertEquals(expected, solution3207.maximumPoints(enemyEnergies, currentEnergy));
    }
}