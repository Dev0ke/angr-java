import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2214Tests {
    private final SolutionP2214 solutionP2214 = new SolutionP2214();

    @Test
    public void example1() {
        int[] damage = {2, 7, 4, 3};
        int armor = 4;
        long expected = 13;
        Assertions.assertEquals(expected, solutionP2214.minimumHealth(damage, armor));
    }

    @Test
    public void example2() {
        int[] damage = {2, 5, 3, 4};
        int armor = 7;
        long expected = 10;
        Assertions.assertEquals(expected, solutionP2214.minimumHealth(damage, armor));
    }

    @Test
    public void example3() {
        int[] damage = {3, 3, 3};
        int armor = 0;
        long expected = 10;
        Assertions.assertEquals(expected, solutionP2214.minimumHealth(damage, armor));
    }
}