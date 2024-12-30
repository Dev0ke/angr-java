import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution726Tests {
    private final Solution726 solution726 = new Solution726();

    @Test
    public void example1() {
        String formula = "H2O";
        String expected = "H2O";
        Assertions.assertEquals(expected, solution726.countOfAtoms(formula));
    }

    @Test
    public void example2() {
        String formula = "Mg(OH)2";
        String expected = "H2MgO2";
        Assertions.assertEquals(expected, solution726.countOfAtoms(formula));
    }

    @Test
    public void example3() {
        String formula = "K4(ON(SO3)2)2";
        String expected = "K4N2O14S4";
        Assertions.assertEquals(expected, solution726.countOfAtoms(formula));
    }
}