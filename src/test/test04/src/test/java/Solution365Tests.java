import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution365Tests {
    private final Solution365 solution365 = new Solution365();

    @Test
    public void example1() {
        int jug1Capacity = 3;
        int jug2Capacity = 5;
        int targetCapacity = 4;
        Assertions.assertTrue(solution365.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
    }

    @Test
    public void example2() {
        int jug1Capacity = 2;
        int jug2Capacity = 6;
        int targetCapacity = 5;
        Assertions.assertFalse(solution365.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
    }

    @Test
    public void example3() {
        int jug1Capacity = 1;
        int jug2Capacity = 2;
        int targetCapacity = 3;
        Assertions.assertTrue(solution365.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
    }
}
