import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1029Tests {
    private final Solution1029 solution1029 = new Solution1029();

    @Test
    public void example1() {
        int[][] costs = UtUtils.stringToInts2("[[10,20],[30,200],[400,50],[30,20]]");
        int expected = 110;
        Assertions.assertEquals(expected, solution1029.twoCitySchedCost(costs));
    }

    @Test
    public void example2() {
        int[][] costs = UtUtils.stringToInts2("[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]");
        int expected = 1859;
        Assertions.assertEquals(expected, solution1029.twoCitySchedCost(costs));
    }

    @Test
    public void example3() {
        int[][] costs = UtUtils.stringToInts2("[[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]");
        int expected = 3086;
        Assertions.assertEquals(expected, solution1029.twoCitySchedCost(costs));
    }
}
