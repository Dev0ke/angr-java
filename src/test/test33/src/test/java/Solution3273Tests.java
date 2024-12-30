import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3273Tests {
    private final Solution3273 solution3273 = new Solution3273();

    @Test
    public void example1() {
        int power = 4;
        int[] damage = {1, 2, 3, 4};
        int[] health = {4, 5, 6, 8};
        long expected = 39;
        Assertions.assertEquals(expected, solution3273.minDamage(power, damage, health));
    }

    @Test
    public void example2() {
        int power = 1;
        int[] damage = {1, 1, 1, 1};
        int[] health = {1, 2, 3, 4};
        long expected = 20;
        Assertions.assertEquals(expected, solution3273.minDamage(power, damage, health));
    }

    @Test
    public void example3() {
        int power = 8;
        int[] damage = {40};
        int[] health = {59};
        long expected = 320;
        Assertions.assertEquals(expected, solution3273.minDamage(power, damage, health));
    }
}