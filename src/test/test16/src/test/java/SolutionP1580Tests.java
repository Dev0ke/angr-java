import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1580Tests {
    private final SolutionP1580 solutionP1580 = new SolutionP1580();

    @Test
    public void example1() {
        int[] boxes = {1, 2, 2, 3, 4};
        int[] warehouse = {3, 4, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1580.maxBoxesInWarehouse(boxes, warehouse));
    }

    @Test
    public void example2() {
        int[] boxes = {3, 5, 5, 2};
        int[] warehouse = {2, 1, 3, 4, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1580.maxBoxesInWarehouse(boxes, warehouse));
    }

    @Test
    public void example3() {
        int[] boxes = {1, 2, 3};
        int[] warehouse = {1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1580.maxBoxesInWarehouse(boxes, warehouse));
    }

    @Test
    public void example4() {
        int[] boxes = {4, 5, 6};
        int[] warehouse = {3, 3, 3, 3, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1580.maxBoxesInWarehouse(boxes, warehouse));
    }
}