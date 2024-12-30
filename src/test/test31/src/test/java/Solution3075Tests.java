import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3075Tests {
    private final Solution3075 solution3075 = new Solution3075();

    @Test
    public void example1() {
        int[] happiness = {1, 2, 3};
        int k = 2;
        long expected = 4;
        Assertions.assertEquals(expected, solution3075.maximumHappinessSum(happiness, k));
    }

    @Test
    public void example2() {
        int[] happiness = {1, 1, 1, 1};
        int k = 2;
        long expected = 1;
        Assertions.assertEquals(expected, solution3075.maximumHappinessSum(happiness, k));
    }

    @Test
    public void example3() {
        int[] happiness = {2, 3, 4, 5};
        int k = 1;
        long expected = 5;
        Assertions.assertEquals(expected, solution3075.maximumHappinessSum(happiness, k));
    }
}