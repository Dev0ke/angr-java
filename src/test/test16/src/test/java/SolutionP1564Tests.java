import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1564Tests {
    private final SolutionP1564 solutionP1564 = new SolutionP1564();

    @Test
    public void example1() {
        int[] boxes = {4, 3, 4, 1};
        int[] warehouse = {5, 3, 3, 4, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1564.maxBoxesInWarehouse(boxes, warehouse));
    }

    @Test
    public void example2() {
        int[] boxes = {1, 2, 2, 3, 4};
        int[] warehouse = {3, 4, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1564.maxBoxesInWarehouse(boxes, warehouse));
    }

    @Test
    public void example3() {
        int[] boxes = {1, 2, 3};
        int[] warehouse = {1, 2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1564.maxBoxesInWarehouse(boxes, warehouse));
    }
}