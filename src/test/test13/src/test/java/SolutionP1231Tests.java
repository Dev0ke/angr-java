import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1231Tests {
    private final SolutionP1231 solutionP1231 = new SolutionP1231();

    @Test
    public void example1() {
        int[] sweetness = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 5;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1231.maximizeSweetness(sweetness, k));
    }

    @Test
    public void example2() {
        int[] sweetness = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        int k = 8;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1231.maximizeSweetness(sweetness, k));
    }

    @Test
    public void example3() {
        int[] sweetness = {1, 2, 2, 1, 2, 2, 1, 2, 2};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP1231.maximizeSweetness(sweetness, k));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] sweetness = {19679, 20653, 68010, 3714, 54485, 548, 41366, 11201, 47138, 70768, 1050, 87246, 17114, 56157, 13235, 65363, 30444, 56929, 21969, 22308};
        int k = 0;
        int expected = 709377;
        Assertions.assertEquals(expected, solutionP1231.maximizeSweetness(sweetness, k));
    }
}
